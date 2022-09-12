<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
</head>
<%User user = (User) session.getAttribute("user");%>
<body>
<div style="margin-left: 40%;width: 18%">
    <a>Hi <%=user.getName()%></a> |
    <a href="/account/add">Add item</a> |
    <a href="/myItems">My Items</a> |
    <a href="/logout">Logout</a>
</div>
</body>
</html>
</html>
