<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.app.pojo.*" %><%@page import="com.app.dao.*" %>
 <%@page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="welcomeHeader.jsp" %>
 <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Leaderboard</title>
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
    <h2>Quiz Results</h2>
    <table>
        <tr>
            <th>Rank</th>
            <th>User</th>
            <th>Score</th>
        </tr>
        <c:forEach var="entry" items="${leaderboard}" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${entry.email}</td>
                <td>${entry.score}</td>
             </tr>
        </c:forEach>
    </table>
</body>
</html>