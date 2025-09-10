package com.eventreminder;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameters
        String username = request.getParameter("username");

        // Write HTML response directly
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>User registered: " + username + "</h2>");
    }

    // Optional: handle GET requests to avoid 405
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("Please submit the form to register.");
    }
}
