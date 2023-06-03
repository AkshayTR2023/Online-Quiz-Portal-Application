<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.app.pojo.*" %><%@page import="com.app.dao.*" %>
 <%@page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="welcomeHeader.jsp" %>
 <%@ include file="goToUserDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Quiz Results</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid black;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<br><br>
<a href="LeaderboardServlet?quizId=<%=request.getParameter("quizId")%>"><button>Leaderboard</button></a>
    <h2>Quiz Results</h2>
    <table>
        <tr>
            <th>Question</th>
            <th>Option 1</th>
            <th>Option 2</th>
            <th>Option 3</th>
            <th>Option 4</th>
            <th>Correct Option</th>
            <th>Your option</th>
            <th>Score</th>
        </tr>
        <c:set var="netScore" value="${0}"></c:set>
        <c:forEach var="question" items="${questionList}" varStatus="loop">
            <tr>
                <td>${question.question}</td>
                       <td>${question.option1}</td>
                      <td>${question.option2}</td>
                      <td>${question.option3}</td>
                      <td>${question.option4}</td>
                <td>${question.correctOption}</td>
				<td>${userAnswers[loop.index]}</td>
				<c:set var="score" value="${0}"></c:set>
				<c:if test="${question.correctOption==userAnswers[loop.index]}">
					<c:set var="score" value="${1}"></c:set>
					<c:set var="netScore" value="${netScore+1}"></c:set>
				</c:if>
				
                <td>${score}</td>
            </tr>
        </c:forEach>
    </table>
    <h3>Net Score: ${netScore}</h3>
</body>
</html>