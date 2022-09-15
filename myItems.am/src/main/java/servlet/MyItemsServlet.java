package servlet;

import manager.ItemManager;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/myItems")
public class MyItemsServlet extends HttpServlet {

    private static final ItemManager itemManager = new ItemManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Item> itemList = itemManager.getItemByUserId(user.getId());
        req.setAttribute("item", itemList);
        req.getRequestDispatcher("/WEB-INF/myItems.jsp").forward(req, resp);
    }
}
