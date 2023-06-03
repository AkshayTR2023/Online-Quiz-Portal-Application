<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<br><br>
	 <h1>Add User</h1>
    <form action="AddUserServlet" method="post">
        <label for="email">Email:</label>
        <input type="email" name="email" id="question" required><br><br>
        
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required><br><br>
        
        <label for="password">Password:</label>
        <input type="text" name="password" id="password" required><br><br>
        
        
        <input type="submit" value="Add User">
        
        
    </form>
    <br>
</body>
</html>