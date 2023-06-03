<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Quiz</title>
</head>
<body>
<br><br>
	<h2>Edit Quiz</h2>
	<form action="EditQuizServlet" method="post">
        <input type="hidden" name="id" value="${quiz.id}">
        <label>Quiz Name</label>
        <input type="text" name="name" value="${quiz.name}">
        <br>
        <input type="submit" value="Save">
    </form>
</body>
</html>