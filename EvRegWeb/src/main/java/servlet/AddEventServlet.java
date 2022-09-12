package servlet;

import lombok.SneakyThrows;
import manager.EventManager;
import model.Event;
import model.EventType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

@WebServlet(urlPatterns = "/events/add")
public class AddEventServlet extends HttpServlet {

    private final EventManager eventManager = new EventManager();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void init() throws ServletException {
        System.out.println("barev");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addEvent.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String place = req.getParameter("place");
        boolean isOnline = Boolean.parseBoolean(req.getParameter("isOnline"));
        EventType eventType = EventType.valueOf(req.getParameter("eventType"));
        double price = Double.parseDouble(req.getParameter("price"));
        String eventDateStr = req.getParameter("eventDate");

        Event event = Event.builder()
                .name(name)
                .place(place)
                .isOnline(isOnline)
                .eventType(eventType)
                .price(price)
                .eventDate(sdf.parse(eventDateStr))
                .build();
        eventManager.add(event);
        resp.sendRedirect("/events");
    }

    @Override
    public void destroy() {
        System.out.println(this.getServletConfig());//kayf?lriv :D ok
        System.out.println("fest");
    }
}
