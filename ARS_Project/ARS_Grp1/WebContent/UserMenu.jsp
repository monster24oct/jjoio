<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<center>
		<h3></h3>
		<form action="AirlineController?action=bookTicket" method="post">
		<button type="submit">
			New Booking
		</button>
		</form>
		<form action="AirlineController?action=viewBooking" method="post">
		<button type="submit">
			View Bookings
		</button>
		</form>
		
		<form action="AirlineController?action=updateBooking" method="post">
		<button type="submit">
			Update Booking
		</button>
		</form>
		
		<form action="AirlineController?action=deleteBooking" method="post">
		<button type="submit">
			Delete Booking
		</button>
		</form>
		</center>
</body>
</html>