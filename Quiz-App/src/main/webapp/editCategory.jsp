<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Category </title>
</head>
<body>
<br><br>
	<h2>Edit Category</h2>
	<form action="EditCategoryServlet" method="post">
        <input type="hidden" name="id" value="${category.id}">
        <label>Category Name</label>
        <input type="text" name="name" value="${category.name}">
        <br>
        <input type="submit" value="Save">
    </form>
</body>
</html>