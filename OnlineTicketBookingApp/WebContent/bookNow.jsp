<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Book Now !!!</title>
	</head>
	<body>
		<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
		<form action="./BookTicket">
			<h1>Booking Form</h1>
			<table>
				<tr>
					<td>Show Name :</td>
					<td><input type="text" name="txtShowName" value="${show.showName}" required></td>
				</tr>
				<tr>
					<td>Price Per Ticket :</td>
					<td><input type="text" name="txtPrice" value="${show.price}" required></td>
				</tr>
				<tr>
					<td>Customer Name</td>
					<td><input type="text" name="txtCustName" required pattern="[A-Za-z]{3,20}"></td>
				</tr>
				<tr>
					<td>Mobile Number :</td>
					<td><input type="text" name="txtMobNo" required pattern="[7-9][0-9]{9}"></td>
				</tr>
				<tr>
					<td>Seats Available :</td>
					<td><input type="text" name="txtSeatsAvail" value="${show.availableSeats}" required ></td>
				</tr>
				<tr>
					<td>No Of Seats to Book : </td>
					<td><input type="text" name="txtSeatsBook" required min="1" max="${show.availableSeats}"></td>
				</tr>
				
				<tr>
					<td  colspan="2">
						<input type="submit" name="btnSubmit" value="book">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>