<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question List Display</title>
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

    <c:if test="${not empty selectedCategory and not empty quizzes}">
        <h2>Quiz: ${selectedCategory.name}</h2>
        <table>
            <thead>
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
            </thead>
            <tbody>
                <c:forEach var="quiz" items="${quizzes}">
                    <c:forEach var="question" items="${quiz.questions}">
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
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>