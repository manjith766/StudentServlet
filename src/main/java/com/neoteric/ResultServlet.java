package com.neoteric;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ResultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("input");
        Student student = StudentDAO.getStudent(input);

        if (student != null) {
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } else {
            response.setContentType("text/html");
            response.getWriter().println("""
                <!DOCTYPE html>
                <html>
                <head><title>Not Found</title></head>
                <body style="text-align: center;">
                    <h3 style="color: red;">No student found for: %s</h3>
                    <a href='index.html'>Back to Search</a>
                </body>
                </html>
                """.formatted(input));
        }
    }
}

