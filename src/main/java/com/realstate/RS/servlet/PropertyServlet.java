package com.realstate.RS.servlet;

import com.realstate.RS.jdbc.JdbcPropertyDAO;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PropertyServlet extends HttpServlet {

    private final JdbcPropertyDAO propertyDAO =
            new JdbcPropertyDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        List<String> properties =
                propertyDAO.getAllProperties();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>JDBC Properties</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Properties - JDBC Servlet</h1>");

        out.println("<ul>");

        for (String property : properties) {

            out.println("<li>");
            out.println(property);
            out.println("</li>");
        }

        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");
    }
}