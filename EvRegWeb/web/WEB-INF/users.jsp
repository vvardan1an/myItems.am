<%@ page import="model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02.09.2022
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Page</title>
</head>
<body>
<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>event id</th>
    </tr>
    <% for (User user : users) { %>
    <tr>
        <td>
            <%= user.getId()%>
        </td>
        <td><%= user.getName()%>
        </td>
        <td><%= user.getSurname()%>
        </td>
        <td><%= user.getEmail()%>
        </td>
        <td><%= user.getEvent()%>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
