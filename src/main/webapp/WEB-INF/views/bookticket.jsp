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

<form action="inserttransaction" method="post">
Bus Name : <select name="bname">
<c:forEach items="${list}" var="b">
<option value="${b.getId()}">${b.getBusName()}, ${b.getAvailable()}
</option>
</c:forEach>
</select>

Transaction Date : <input type="date" name="t_date"><br><br>
Transaction Status : <input type="text" name="t_status"><br><br>
Number Of Tickets : <input type="number" name="noft"><br><br>
User Id : <input type="text" name="user_id" value=${email}><br><br>

<input type="submit" value="book">

</form>


</body>
<a href="home">Home</a>
</html>