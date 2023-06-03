<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="welcomeHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard | Quiz App</title>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .box {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
        }

        .section {
            margin-top: 20px;
        }

        .option {
            margin-bottom: 10px;
        }

        .button {
            width: 150px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="box">
        	<div class="section">
                <h2>Category Manager</h2>
                <select onchange="handleCategoryManager(this)" class="option">
                    <option value="">Select an option</option>
                    <option value="createCategory">Create New Category</option>
                    <option value="categoryList">Category List</option>
                </select>
            </div>      
            <div class="section">
                <h2>Quiz Manager</h2>
                <select onchange="handleQuizManager(this)" class="option">
                    <option value="">Select an option</option>
                    <option value="createQuiz">Create New Quiz</option>
                    <option value="quizList">Quiz List</option>
                </select>
            </div>

            <div class="section">
                <h2>Question Manager</h2>
                <select onchange="handleQuestionManager(this)" class="option">
                    <option value="">Select an option</option>
                    <option value="addQuestion">Add New Question</option>
                    <option value="questionList">Question List</option>
                </select>
            </div>

            

            <script>
                function handleQuizManager(select) {
                    var selectedOption = select.value;
                    if (selectedOption === "createQuiz") {
                        // Redirect to create new quiz page
                        window.location.href = "AddQuizServlet";
                    } else if (selectedOption === "quizList") {
                        // Redirect to quiz list page
                        window.location.href = "QuizListServlet";
                    }
                }

                function handleQuestionManager(select) {
                    var selectedOption = select.value;
                    if (selectedOption === "addQuestion") {
                        // Redirect to add new question page
                        window.location.href = "selectCategory.jsp";
                    } else if (selectedOption === "questionList") {
                        // Redirect to question list page
                        window.location.href = "QuestionListServlet";
                    }
                }

                function handleCategoryManager(select) {
                    var selectedOption = select.value;
                    if (selectedOption === "createCategory") {
                        // Redirect to create new category page
                        window.location.href = "addCategory.jsp";
                    } else if (selectedOption === "categoryList") {
                        // Redirect to category list page
                        window.location.href = "CategoryListServlet";
                    }
                }
            </script>

            <div class="section">
                <br><br>
                <a href="UserListServlet"><button class="button">User Operation</button></a><br><br>
                <a href="adminSelectCategory.jsp"><button class="button">View Leaderboard</button></a><br>
            </div>
        </div>
    </div>
</body>
</html>
