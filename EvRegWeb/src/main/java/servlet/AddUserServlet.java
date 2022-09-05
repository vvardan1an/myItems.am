package servlet;

import lombok.SneakyThrows;
import manager.EventManager;
import manager.UserManager;
import model.Event;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/users/add")
public class AddUserServlet extends HttpServlet {

    private final UserManager userManager = new UserManager();
    private final EventManager eventManager = new EventManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int id = Integer.parseInt(req.getParameter("eventId"));


        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .event(eventManager.getById(id))
                .build();
        userManager.add(user);
        resp.sendRedirect("/users");
    }

}
