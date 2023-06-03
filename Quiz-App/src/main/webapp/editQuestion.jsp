<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Question</title>
</head>
<body>
<br><br>
	<h2>Edit Question</h2>
	<form action="EditQuestionServlet" method="post">
        <input type="hidden" name="id" value="${question.id}">
        <label>Question:</label>
        <input type="text" name="question" value="${question.question}">
        <br>
        <label>Option 1:</label>
        <input type="text" name="option1" value="${question.option1}">
        <br>
        <label>Option 2:</label>
        <input type="text" name="option2" value="${question.option2}">
        <br>
        <label>Option 3:</label>
        <input type="text" name="option3" value="${question.option3}">
        <br>
        <label>Option 4:</label>
        <input type="text" name="option4" value="${question.option4}">
        <br>
        <label>Correct Option:</label>
        <input type="number" name="correctOption" value="${question.correctOption}">
        <br>
        <input type="submit" value="Save">
    </form>
</body>
</html>