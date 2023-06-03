<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Quiz-App</title>
</head>

<body><center>
		<% String logout = request.getParameter("logout"); %>
	 	<% if (logout != null && logout.equals("true")) { %>
  			 <h2>Logged out successfully!</h2>
  		<% } %>

	<h1>Welcome to Quiz Program!</h1>
   <a href="register.jsp"><button style="width:150px">New User Registration</button></a>
    <br><br>
     <a href="userLogin.jsp"><button style="width:150px">User Login</button></a>
    <br><br>
     <a href="adminLogin.jsp"><button style="width:150px">Admin Login</button></a>
     </center>
</body>
</html>