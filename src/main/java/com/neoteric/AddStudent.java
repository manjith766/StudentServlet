package com.neoteric;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddStudent extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String hall = request.getParameter("hallticket");
        String name = request.getParameter("name");
        int marks = Integer.parseInt(request.getParameter("marks"));

        Student student = new Student(hall, name, marks);
        boolean added = StudentDAO.addStudent(student);

        response.setContentType("text/html");
        if (added) {
            response.getWriter().println("<h3> Student added successfully!</h3>");
        } else {
            response.getWriter().println("<h3>Failed to add student.</h3>");
        }
    }

}

