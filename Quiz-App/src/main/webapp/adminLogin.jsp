<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="goHome.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<center>
	<h1>Welcome Back!</h1>
    <form action="AdminLoginServlet" method="post">
        <input type="email" name="email" required placeholder="Enter email ID" required><br>
        <input type="password" name="password" required placeholder="Enter password" required><br><br>
        <input type="submit" value="Login">
    </form>
    <br>
    <a href="adminPwdChange.jsp"><button style="width:150px">Change Password</button></a>
    </center>
</body>
</html>