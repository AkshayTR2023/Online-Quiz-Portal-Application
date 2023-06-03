<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="goHome.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<center>
	<h1>Welcome!</h1>
    <form action="LoginServlet" method="post">
        <input type="email" name="email" required placeholder="Enter email ID" required><br>
        <input type="password" name="password" required placeholder="Enter password" required><br><br>
        <input type="submit" value="Login">
    </form>
    <br>
    <a href="pwdChange.jsp"><button style="width:150px">Change Password</button></a>
    </center>
</body>
</html>