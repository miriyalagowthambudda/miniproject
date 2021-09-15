<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="post">

Email : <input type="email" name="email" value="${user.getEmail()}"><br><br>
User Name : <input type="text" name="uname" value="${user.getName()}"><br><br>
Mobile : <input type="text" name="mobile" value="${user.getMobile()}"><br><br>
Password : <input type="password" name="password" value="${user.getPassword()}"><br><br>
 <input type="hidden" name="utype" value="${user.getRole()}"><br><br>

<input type="submit" value="update user details">





</form>
<a href="home">Home</a>
</body>
</html>