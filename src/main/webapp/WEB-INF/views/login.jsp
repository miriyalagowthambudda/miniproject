<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4 style="color:red">${msg}</h4>
<form action="checkuser">
User Name : <input type="email" name="email"><br><br>
Password  : <input type="password" name="password" placeholder="Enter your password"><br><br>
<input type="submit" value="login">

</form>

</body>
</html>