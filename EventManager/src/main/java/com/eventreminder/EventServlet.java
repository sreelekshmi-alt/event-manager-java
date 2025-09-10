package com.eventreminder;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/event")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
    private EventDAO eventDAO = new EventDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        User user = (User) session.getAttribute("user");
        String action = req.getParameter("action");
        try {
            if ("add".equals(action)) {
                Event e = mapRequestToEvent(req);
                e.setUserId(user.getId());
                eventDAO.addEvent(e);
                resp.sendRedirect("events.jsp");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private Event mapRequestToEvent(HttpServletRequest req) {
        Event e = new Event();
        e.setName(req.getParameter("name"));
        e.setDescription(req.getParameter("description"));
        e.setCategory(req.getParameter("category"));
        e.setLocation(req.getParameter("location"));
        String date = req.getParameter("event_date");
        String time = req.getParameter("event_time");
        if (date != null && !date.isEmpty()) e.setEventDate(LocalDate.parse(date));
        if (time != null && !time.isEmpty()) e.setEventTime(LocalTime.parse(time));
        String p = req.getParameter("priority");
        e.setPriority(p != null ? Integer.parseInt(p) : 0);
        return e;
    }
}
