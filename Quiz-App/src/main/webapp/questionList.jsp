<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.app.pojo.*" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<a href="adminDashboard.jsp"><button>Go Back to Dashboard</button></a>
<html>
<head>
    <meta charset="UTF-8">
    <title>Question List</title>
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
    <h2>Question List</h2>
    <form action="QuestionListServlet" method="post">
        <label for="category">Select Category:</label>
        <select name="category" id="category" onchange="this.form.submit()">
            <option value="">Select a category</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}" <c:if test="${not empty selectedCategory and category.id == selectedCategory.id}">selected</c:if>>${category.name}</option>
            </c:forEach>
        </select>
    </form>

    <c:choose>
        <c:when test="${not empty selectedCategory and empty quizzes}">
            <h2>No quizzes available for Category: ${selectedCategory.name}</h2>
            <p>Please select a different category.</p>
        </c:when>
        <c:when test="${not empty selectedCategory and not empty quizzes}">
            <h2>Quizzes for Category: ${selectedCategory.name}</h2>
            <form action="QuestionListServlet" method="post">
                <input type="hidden" name="category" value="${selectedCategory.id}" />
                <label for="quiz">Select Quiz:</label>
                <select name="quiz" id="quiz" onchange="this.form.submit()">
                    <option value="">Select a quiz</option>
                    <c:forEach var="quiz" items="${quizzes}">
                        <option value="${quiz.id}" <c:if test="${not empty selectedQuiz and quiz.id == selectedQuiz.id}">selected</c:if>>${quiz.name}</option>
                    </c:forEach>
                </select>
            </form>
        </c:when>
    </c:choose>

    <c:if test="${not empty selectedQuiz and not empty questions}">
        <h2>Questions for Quiz: ${selectedQuiz.name}</h2>
        <table>
            <tr>
                <th>Question</th>
                <th>Option 1</th>
                <th>Option 2</th>
                <th>Option 3</th>
                <th>Option 4</th>
                <th>Correct Option</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="question" items="${questions}">
                <tr>
                    <td>${question.question}</td>
                    <td>${question.option1}</td>
                    <td>${question.option2}</td>
                    <td>${question.option3}</td>
                    <td>${question.option4}</td>
                    <td>${question.correctOption}</td>
                    <td><a href="EditQuestionServlet?id=${question.id}">Edit</a></td>
                    <td><a href="DeleteQuestionServlet?id=${question.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
