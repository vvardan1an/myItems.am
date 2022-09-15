package servlet;

import lombok.SneakyThrows;
import manager.CategoryManager;
import manager.ItemManager;

import model.Category;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


@WebServlet(urlPatterns = "/item/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddItemServlet extends HttpServlet {

    private final ItemManager itemManager = new ItemManager();
    private final CategoryManager categoryManager = new CategoryManager();

    private static final String IMAGE_PATH = "C:\\Users\\user\\IdeaProjects\\myItems.am\\ItemImages\\";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryManager.getAll());
        req.setAttribute("item", itemManager.getAll());
        req.getRequestDispatcher("/WEB-INF/addItems.jsp").forward(req, resp);

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        Category category = categoryManager.getCategoryById(Integer.parseInt(req.getParameter("categoryId")));
        User user = (User) req.getSession().getAttribute("user");
        Part catPic = req.getPart("image");
        String fileName = null;

        if (catPic.getSubmittedFileName().length() != 0) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + catPic.getSubmittedFileName();
            catPic.write(IMAGE_PATH + fileName);
        }

        itemManager.add(Item.builder()
                .user(user)
                .title(title)
                .price(price)
                .category(category)
                .catPic(fileName)
                .build());

        resp.sendRedirect("/");
    }
}
