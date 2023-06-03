<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="goToAdminDashboard.jsp" %>
    <%@ include file="welcomeHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<br><br>
	<h2>Edit User</h2>
	<form action="EditUserServlet" method="post">
        <input type="hidden" name="id" value="${user.email}">
        <label>Name:</label>
        <input type="text" name="name" value="${user.name}">
        <br>
        <label>Password:</label>
        <input type="text" name="password" value="${user.password}">
        <br>
        <input type="submit" value="Save">
    </form>
</body>
</html>