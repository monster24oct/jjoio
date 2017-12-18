<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form action="SuccessReg.jsp">
<h2 align="center">Register</h2>
	<table align="center">
		<tr>
			<td><label>Username:</label></td>
			<td><input type="text" name="name" pattern="[A-Za-z\s]{4,30}" required></td>
		</tr>
		<tr>
			<td><label>Password:</label></td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td><label>Role:</label></td>
			<td><select name="role">
					<option value="Passenger">Passenger
					<option value="Administrator">Administrator
					<option value="Airline_Executive">Airline Executive
				  </select></td>
		</tr>
		<tr>
			<td><label>Mobile No:</label></td>
			<td><input type="number" name="number" pattern="[1-9][0-9]{9}" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="submit">Register</button></td>
		</tr>
		
	</table>
   <!--  <div align="right"> <button type="submit">Login</button></div>-->
</form>
</body>
</html>