<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <style>
        .welcome-message {
            position: fixed;
            top: 0;
            right: 0;
            padding: 10px;
            background-color: #f5f5f5;
        }
        .logout-link {
            position: fixed;
            top: 40px;
            right: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="welcome-message">
        Welcome, <%= session.getAttribute("email") %>
    </div>
     <div class="logout-link">
        <a href="logout.jsp"><button>Logout</button></a>
    </div>
</body>
</html>