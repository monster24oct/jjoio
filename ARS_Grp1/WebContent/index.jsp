<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="AirlineController?action=login" method="post">
<h2 align="center">Login</h2>
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
			<td colspan="2" align="center"><button type="submit">Login</button></td>
		</tr>
	</table>
   <div align="right"> <button type="submit">Create a new account</button></div>
</form>
</body>
</html>