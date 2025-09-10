package com.eventreminder;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if ("register".equals(action)) {
                User u = new User();
                u.setUsername(req.getParameter("username"));
                u.setEmail(req.getParameter("email"));
                u.setPassword(req.getParameter("password"));
                u.setFullName(req.getParameter("fullName"));
                boolean ok = userDAO.register(u);
                resp.sendRedirect(ok ? "login.jsp?msg=registered" : "register.jsp?error=fail");
            } else if ("login".equals(action)) {
                String key = req.getParameter("key");
                String password = req.getParameter("password");
                User u = userDAO.findByUsernameOrEmail(key);
                if (u != null && u.getPassword().equals(password)) {
                    HttpSession s = req.getSession();
                    s.setAttribute("user", u);
                    resp.sendRedirect("events.jsp");
                } else {
                    resp.sendRedirect("login.jsp?error=invalid");
                }
            } else if ("logout".equals(action)) {
                req.getSession().invalidate();
                resp.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
