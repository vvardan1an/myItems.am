<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/register" method="post">

    Please input  name:
    <input name="name" placeholder="Name">
    Please input  surname:
    <input name="surname" placeholder="Surname">
    Please input  email:
    <input type="email" name="email" placeholder="example@gmail.com">
    Please input  password:
    <input type="password" name="password" placeholder="password">

    <input type="submit" value="Register">

</form>
</body>
</html>
