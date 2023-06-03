<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.app.pojo.Question"%>
<%@ page import="com.app.dao.QuestionDao"%>
<%@ include file="welcomeHeader.jsp" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Attend Quiz</title>
</head>
<body>
    <h2>Quiz: ${quiz.name}</h2>
    <h2>Category: ${quiz.category.name}</h2>
    <form action="QuizSubmitServlet?quizId=${quizId}" method="POST">

        <% String quizId = request.getParameter("quizId"); %>
        <% List<Question> questions = QuestionDao.getQuestionsByQuizId(Integer.parseInt(quizId)); %>
		<h2>Number of questions: <%= questions.size() %></h2>
        <% for (int i = 0; i < questions.size(); i++) { %>
    <% Question question = questions.get(i); %>
    <h3>Question <%= i + 1 %>:</h3>
    <p><%= question.getQuestion() %></p>
    <input type="radio" name="answer<%= i + 1 %>" value="1" required><%= question.getOption1() %><br>
    <input type="radio" name="answer<%= i + 1 %>" value="2" required><%= question.getOption2() %><br>
    <input type="radio" name="answer<%= i + 1 %>" value="3" required><%= question.getOption3() %><br>
    <input type="radio" name="answer<%= i + 1 %>" value="4" required><%= question.getOption4() %><br>
    <br>
<% } %>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
