<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="welcomeHeader.jsp" %>
    <%@ include file="goToAdminDashboard.jsp" %>
 <%@page import="com.app.pojo.*" %>
 <%@page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Quiz</title>
</head>
<body>
<br><br>
	 <h1>Add Quiz</h1>
    <form action="AddQuizServlet" method="post">
        <label for="name">Quiz Title</label>
        <input type="text" name="name" id="name" required><br><br>
        
        
         <label for="category">Category:</label>
    	<select id="category" name="category" required>
        <!-- Populate the dropdown with available categories -->
        <c:forEach var="category" items="${categoryList}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
        <input type="submit" value="Add Quiz">
        
        
    </form>
    <br>
</body>
</html>