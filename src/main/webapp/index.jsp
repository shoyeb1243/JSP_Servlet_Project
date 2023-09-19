<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regsterForm" method="post">
		Name : <input type="text" name="name1" placeholder="Enter Name" /><br>
		<br> Email : <input type="text" name="email1"
			placeholder="Enter Email" /><br> <br> Password : <input
			type="password" name="pass1" placeholder="Enter Password" /><br>
		<br> Gender : <input type="radio" name="gender1" value="Male" />Male<input
			type="radio" name="gender1" value="Female" />Female<input
			type="radio" name="dender1" value="Custom" />Custom<br> <br>
		City : <select name="city1">
			<option>Select City</option>
			<option>Mumbai</option>
			<option>Lucknow</option>
			<option>Basti</option>
			<option>Sant Kabir Nagar</option>
		</select><br> <br> <select name="contry1">
			<option>Select Contry</option>
			<option>India</option>
			<option>Australia</option>
			<option>Conada</option>
			<option>Bangladesh</option>
			<option>Afghanistan</option>
		</select><br> <br> <input type="submit" value="Regster" />
	</form>
</body>
</html>