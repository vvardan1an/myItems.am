<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    String message = (String) request.getAttribute("message");
%>


<%
    if(message !=null){%>
<p style="color: red"><%=message%>

</p>
<%}%>
<form action="/login" method="post">
    <input type="email" name="email" placeholder="Please input email:">
    <input type="password" name="password" placeholder="Please input password:">
    <input type="submit" value="login">

</form>
</body>
</html>
