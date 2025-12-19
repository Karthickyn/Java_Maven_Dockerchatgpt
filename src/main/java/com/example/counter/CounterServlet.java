package com.example.counter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class CounterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 0;
        }

        String action = request.getParameter("action");

        if ("inc".equals(action)) count++;
        if ("dec".equals(action)) count--;
        if ("reset".equals(action)) count = 0;

        session.setAttribute("count", count);
        response.sendRedirect("index.jsp");
    }
}
