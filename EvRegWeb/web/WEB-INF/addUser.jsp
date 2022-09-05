<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02.09.2022
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>

Please input user data:
<form action="/users/add" method="post">

    <input type="text" name="name" placeholder="Name">
    <br>
    <input type="text" name="surname" placeholder="Surname">
    <br>
    <input type="text" name="email" placeholder="Email">
    Event Id
    <select name="eventId">
        <option value="1">FILM</option>
        <option value="2">SPORT</option>
        <option value="3">GAME</option>
    </select>
    <br>
    <input type="submit" value="Add">



</form>

</body>
</html>
