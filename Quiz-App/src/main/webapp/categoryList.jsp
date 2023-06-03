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
    <title>Category List</title>
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
    <h2>Category List</h2>
    <table>
        <tr>
            <th>Category</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="category" items="${categoryList}">
            <tr>
                <td>${category.name}</td>
                <td><a href="EditCategoryServlet?id=${category.id}">Edit</a></td>
                <td><a href="DeleteCategoryServlet?id=${category.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>