<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 08/09/2025
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.sql.Date" %>
<%@ page import="iuh.fit.nguyenphanminhman_22679171_week03.model.Account" %>
<html>
<head>
    <title>Account List</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f7fafd; }
        h1 { text-align: center; }
        table { margin: 0 auto; border-collapse: collapse; width: 80%; background: #fff; }
        th, td { border: 1px solid #cbd5e1; padding: 10px 14px; text-align: center; }
        th { background: #1675fa; color: #fff; }
        tr:nth-child(even) { background: #f0f5ff; }
    </style>
</head>
<body>
<h1>Account List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <!-- <th>Gender</th> Nếu có trường gender thì thêm cột này -->
    </tr>
    <%
        List<Account> accounts = (List<Account>) request.getAttribute("accounts");
        if (accounts != null && !accounts.isEmpty()) {
            for (Account acc : accounts) {
    %>
    <tr>
        <td><%= acc.getId() %></td>
        <td><%= acc.getFirstname() %></td>
        <td><%= acc.getLastname() %></td>
        <td><%= acc.getEmail() %></td>
        <td><%= acc.getDateOfBirth() %></td>

    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No account found.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>