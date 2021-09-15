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

<h1 style="color:green"> welcome "${name}" </h1>

<a href="updateuser?email=${email}">Edit</a>
<a href="addbus">Add Bus</a>
<a href="viewbusses">View Busses</a>
<a href="bookticket?email=${email}">Book Ticket</a>
</body>
</html>