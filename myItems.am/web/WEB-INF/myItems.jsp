<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.09.2022
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Items</title>
</head>
<body>
<%
    List<Item> items = (List<Item>) request.getAttribute("item");
    for (Item item : items) {
%>
<div>
        <% if (item.getCatPic() == null || item.getCatPic().length() == 0) {%>
    <img src="C:\Users\user\IdeaProjects\myItems.am\web\defImg\default-29e298d98dd1d0744190f12619653717.jpg" width="16%">
         width="100"/>
        <%} else {%>
    <img src="/getImage?catPic=<%=item.getCatPic()%>" width="16%">
        <%}%><br>
        <%=item.getTitle()%><br>
        <%=item.getPrice()%><br>
            <a href="/item/remove?itemId=<%=item.getId()%>">Remove item</a>
        <% if (item.getCategory() != null) {%>
        <%=item.getCategory().getName()%>
        <%} else {%>
    Category does not exist
        <%}%>
        <%}%>
</body>
</html>
