<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus ticket booking</title>

</head>	
<body>

<form action="insertbus" method="post" enctype="multipart/form-data">


Bus Name : <input type="text" name="bname"><br><br>
Start Date : <input type="date" name="start_date"><br><br>
Start Time : <input type="time" name="start_time"><br><br>
Number Of Seats : <input type="number" name="nofs"><br><br>
Availability : <input type="number" name="avail"><br><br>
From : <select name="fromC">
<option value="Vijayawada">Vijayawada</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Visakhapatnam">Visakhapatnam</option>
<option value="Srikakulam">Srikakulam</option>
<option value="Guntur">Guntur</option>
</select>

To : <select name="toC">
<option value="Vijayawada">Vijayawada</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Visakhapatnam">Visakhapatnam</option>
<option value="Srikakulam">Srikakulam</option>
<option value="Guntur">Guntur</option>
</select>

Bus Type : <select name="btype">
<option value="AC">AC</option>
<option value="NON-AC">NON-AC</option>
</select>

Cost : <input type="number" name="cost"><br><br>
upload image:
<input type="file" name="file"><br><br>
<input type="submit" value="add bus">



</form>
<a href="home">Home</a>
</body>
</html>