<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.app.pojo.*" %>
 <%@page import="java.util.*" %>
 <%@ include file="welcomeHeader.jsp" %>
 <%@ include file="goToAdminDashboard.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>User List</title>
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
	 <center><a href="addUser.jsp"><button style="width:150px">Add User</button></a></center>
	 <br>
    <h2>User List</h2>
    <table>
        <tr>
            <th>User Email</th>
            <th>User name</th>
            <th>Password</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.email}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td><a href="EditUserServlet?id=${user.email}">Edit</a></td>
                <td><a href="DeleteUserServlet?id=${user.email}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>