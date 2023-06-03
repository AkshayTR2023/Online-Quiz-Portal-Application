<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<form action="AdminPwdServlet" method="post">
		<input type="email" name="email" required placeholder="Enter email ID" required><br>
        <input type="password" name="oldPwd" required placeholder="Enter old password" required><br>
        <input type="password" name="newPwd" required placeholder="Enter new password" required><br><br>
        <input type="submit" value="Confirm">
    </form>
</body>
</html>