-<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.app.pojo.*" %>
 <%@page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="welcomeHeader.jsp" %>
 <%@ include file="goToAdminDashboard.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Quiz List</title>
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
    <h2>Quiz List</h2>
    <table>
        <tr>
        	<th>Sr No.</th>
            <th>Quiz</th>
            <th>Category</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
         <c:set var="serialNumber" value="1" scope="page"/>
        <c:forEach var="quiz" items="${quizList}">
            <tr>
            	<td>${serialNumber}</td>
                <td>${quiz.name}</td>
                <td>${quiz.category.name}</td>
                <td><a href="EditQuizServlet?id=${quiz.id}">Edit</a></td>
                <td><a href="DeleteQuizServlet?id=${quiz.id}">Delete</a></td>
            </tr>
         <c:set var="serialNumber" value="${serialNumber + 1}" scope="page"/>
        </c:forEach>
    </table>
</body>
</html>