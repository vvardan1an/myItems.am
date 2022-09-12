package servlet;

import lombok.SneakyThrows;
import manager.CategoryManager;
import manager.ItemManager;
import manager.UserManager;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/account/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddItemServlet extends HttpServlet {

    private static final ItemManager itemManager = new ItemManager();
    private static final CategoryManager categoryManager = new CategoryManager();
    private static final UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addItem.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String catPic = req.getParameter("catPic");
        int userId = Integer.parseInt(req.getParameter("userId"));



        Item item = Item.builder()
                .title(title)
                .price(price)
                .category(categoryManager.getById(categoryId))
                .catPic(catPic)
                .user(userManager.getById(userId))
                .build();
        itemManager.add(item);
        resp.sendRedirect("/account");
    }

}
