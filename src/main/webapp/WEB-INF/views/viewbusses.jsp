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

<table>
<tr>
<th>Bus Id</th>
<th>Bus Name</th>
<th>Start Date</th>
<th>Start Time</th>
<th>Number of Seats</th>
<th>Available</th>
<th>From City</th>
<th>To City</th>
<th>Bus Type</th>
<th>Cost</th>
</tr>

<c:forEach items="${list}" var="b">
<tr>

<td>${b.getId()}</td>
<td>${b.getBusName()}</td>
<td>${b.getStartDate()}</td>
<td>${b.getStartTime()}</td>
<td>${b.getNumOfSeats()}</td>
<td>${b.getAvailable()}</td>
<td>${b.getFromC()}</td>
<td>${b.getToC()}</td>
<td>${b.getBtype()}</td>
<td>${b.getCost()}</td>
<td><img src="/imageDisplay?id=${b.getId()}" width="70" height="70"></td>

</tr>

</c:forEach>

</table>

</body>
<a href="home">Home</a>
</html>