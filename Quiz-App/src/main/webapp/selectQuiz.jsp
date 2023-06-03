<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
     <%@page import="com.app.pojo.*" %>
       <%@page import="com.app.dao.*" %>
 <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Quiz</title>
</head>
<body>
<br><br>
    <h1>Select Quiz</h1>
    <form action="AddQuestionServlet" method="get">
        <%-- Retrieve the selected category ID from the session attribute --%>
        <% int categoryId = (int) request.getSession().getAttribute("categoryId"); %>
        <input type="hidden" name="categoryId" value="<%= categoryId %>">
        
        <label for="quiz">Quiz:</label>
        <select id="quiz" name="quizId">
            <%-- Retrieve the list of quizzes for the selected category from the database --%>
            <% Category category=CategoryDao.getCategoryById(categoryId); %>
            <% List<Quiz> quizzes = QuizDao.getQuizzesByCategory(category); %>
            <% for (Quiz quiz : quizzes) { %>
                <option value="<%= quiz.getId() %>"><%= quiz.getName() %></option>
            <% } %>
        </select>
        <br><br>
        <input type="submit" value="Select Quiz">
    </form>
</body>
</html>
