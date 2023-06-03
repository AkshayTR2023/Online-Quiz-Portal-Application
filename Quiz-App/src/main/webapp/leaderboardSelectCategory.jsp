<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ include file="welcomeHeader.jsp" %>
     <%@page import="com.app.pojo.*" %>
       <%@page import="com.app.dao.*" %>
 <%@page import="java.util.*" %>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Category</title>
</head>
<body>
<br><br>
    <h1>Select Category</h1>
    <form action="LeaderboardSelectQuizServlet" method="post">
        <label for="category">Category:</label>
        <select id="category" name="categoryId">
            <%-- Retrieve the list of categories from the database --%>
            <% List<Category> categories = CategoryDao.getAllCategories(); %>
            <% for (Category category : categories) { %>
                <option value="<%= category.getId() %>"><%= category.getName() %></option>
            <% } %>
        </select>
        <br><br>
        <input type="submit" value="Select Category">
    </form>
</body>
</html>