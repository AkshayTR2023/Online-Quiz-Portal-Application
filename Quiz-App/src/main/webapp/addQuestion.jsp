<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question</title>
</head>
<body>
<br><br>
	 <h1>Add Question</h1>
	 <a href="adminDashboard.jsp"><button>Done</button> </a>
    <form action="AddQuestionServlet" method="post">
    	  <input type="hidden" name="quizId" value="${param.quizId}">
        <label for="question">Question:</label>
        <input type="text" name="question" id="question" required><br><br>
        
        <label for="option1">Option 1:</label>
        <input type="text" name="option1" id="option1" required><br><br>
        
        <label for="option2">Option 2:</label>
        <input type="text" name="option2" id="option2" required><br><br>
        
        <label for="option3">Option 3:</label>
        <input type="text" name="option3" id="option3" required><br><br>
        
        <label for="option4">Option 4:</label>
        <input type="text" name="option4" id="option4" required><br><br>
        
         <label for="correctOption">Correct Option:</label>
        <select name="correctOption" id="correctOption" required>
            <option value="1">Option 1</option>
            <option value="2">Option 2</option>
            <option value="3">Option 3</option>
            <option value="4">Option 4</option>
        </select><br><br>
        
        <input type="submit" value="Add Question">
        
        
    </form>
    <br>
</body>
</html>