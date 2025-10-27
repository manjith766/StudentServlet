package com.neoteric;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public static Student getStudent(String input) {
        Student student = null;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM students WHERE hallticket = ? OR name = ?");
            ps.setString(1, input);
            ps.setString(2, input);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(
                        rs.getString("hallticket"),
                        rs.getString("name"),
                        rs.getInt("marks")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public static boolean addStudent(Student student) {
        boolean added = false;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO students (hallticket, name, marks) VALUES (?, ?, ?)");
            ps.setString(1, student.getHallTicket());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getMarks());
            added = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return added;
    }
}