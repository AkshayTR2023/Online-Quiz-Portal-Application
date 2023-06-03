<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="welcomeHeader.jsp" %>
    <%@ page import="com.app.pojo.Quiz"%>
   <%@ page import="java.util.*"%>
     <%@ page import="com.app.dao.QuizDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Quizzes</h2>
    <table>
        <thead>
            <tr>
                <th>Quiz Name</th>
                <th>Category</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%-- Retrieve the list of quizzes from the database using QuizDAO --%>
            <% List<Quiz> quizzes = QuizDao.getAllQuizzes(); %> 

            <%-- Iterate over the list of quizzes and display them --%>
            <% for (Quiz quiz : quizzes) { %>
                <tr>
                    <td><%= quiz.getName() %></td>
                    <td><%= quiz.getCategory().getName() %></td>
                    <td><a href="AttendQuizServlet?quizId=<%= quiz.getId() %>">Start Quiz</a></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <a href="leaderboardSelectCategory.jsp"><button>View Leaderboard</button></a>
</body>
</html>
