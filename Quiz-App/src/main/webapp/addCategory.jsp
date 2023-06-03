<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
<br><br>
	 <h1>Add Category</h1>
    <form action="AddCategoryServlet" method="post">
        <label for="name">Category Title</label>
        <input type="text" name="name" id="name" required><br><br>
        
        <input type="submit" value="Add Category">
        
        
    </form>
    <br>
</body>
</html>