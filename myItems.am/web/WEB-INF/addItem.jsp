<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<%
    List<Category> categoryList = (List<Category>) request.getAttribute("category");

    List<User> userList = (List<User>) request.getAttribute("user");

    Item item = new Item();
%>

<form action="/account/add" method="post" enctype="multipart/form-data">
    Please input  title:
    <input name="title" placeholder="Title">
    Please input  price:
    <input name="price" placeholder="Price">
    Please choose category:
    <select name="category">
        <% for (Category category : categoryList) { %>
        <option value="<%=category.getName()%>">
        </option>
        <%}%>
    </select>
    Please choose author:
    <select name="user">
        <% for (User user : userList) { %>
        <option value="<%=user.getName()%>">
        </option>
        <%}%>
    </select>

    <input type="file" name="image">

    <input type="submit" value="Add">

</form>
</body>
</html>
