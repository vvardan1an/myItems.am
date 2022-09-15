<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession();
    User user = (User) session1.getAttribute("user");

    List<Category> categoryList = (List<Category>) request.getAttribute("categories");
%>

<form action="/item/add" method="post" enctype="multipart/form-data">
    <input type="hidden" name="userId"<%=user.getId()%>>
    <input type="text" name="title" placeholder="title">
    <input type="number" name="price" placeholder="price">

    <select name="categoryId">
        <% for (Category category : categoryList) { %>
        <option value="<%=category.getId()%>"><%=category.getName()%></option>
        <%}%>
    </select>

    <input type="file" name="image">
    <input type="submit" value="Add">

</form>

</body>
</html>
