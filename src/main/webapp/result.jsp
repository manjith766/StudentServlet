<%@ page import="com.neoteric.Student" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
</head>
<body style="font-family: Arial; text-align: center;">
    <h2>Student Result</h2>
    <table border="1" align="center" cellpadding="10">
        <tr><th>Hall Ticket</th><td><%= student.getHallTicket() %></td></tr>
        <tr><th>Name</th><td><%= student.getName() %></td></tr>
        <tr><th>Marks</th><td><%= student.getMarks() %></td></tr>
        <tr>
            <th>Result</th>
            <td style="color:<%= student.getResult().equals("Pass") ? "green" : "red" %>;">
                <%= student.getResult() %>
            </td>
        </tr>
    </table>
    <br>
    <a href="index.html">Back</a>
</body>
</html>
