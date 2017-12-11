<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
    border: 2px solid blue;
}
</style>
</head>
<body>
<form action="ProcessUser?action=register" method="post">
<h2 align="center">MyAir Telecommunication </h2>
<h2 align="center">User Registration Form</h2>
	<table align="center">
		<tr>
			<td><label>Enter Your Name</label></td>
			<td><input type="text" name="name" pattern="[A-Za-z\s]{2,20}" required></td>
		</tr>
		<tr>
			<td><label>Mobile Number</label></td>
			<td><input type="text" name="number" pattern="[0-9]{10}" title="10 digits compulsary" required></td>
		</tr>
		<tr>
			<td><label>Username</label></td>
			<td><input type="text" name="username" pattern="[A-Za-z]{2,40}" title="Only characters allowed(minimum 2)" required></td>
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td><label>Confirm Password</label></td>
			<td><input type="password" name="passwd" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="submit">Register</button></td>
		</tr>
	</table>
</form>
</body>
</html>