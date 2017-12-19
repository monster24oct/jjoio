<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
		<h2>List Of Movie Shows</h2>
		<table border="1">
			<tr>
				<th>Flight ID</th>
				<th>Airline</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Dept Time</th>
				<th>Arrival Time</th>
				<th>Available Seats</th>
				<th>Business Fare</th>
				<th>Economy Fare</th>
				<th>action</th>
			</tr>
			
			<s:forEach var="show" items="${listFlightDto}">
				<tr>
					<td>${show.flightId}</td>
					<td>${show.airline}</td>
					<td>${show.departureCity}</td>
					<td>${show.arrivalCity}</td>
					<td>${show.departureTime}</td>
					<td>${show.arrivalTime}</td>
					<td>${show.noOfSeats}</td>
					<td>${show.ecoFare}</td>
					<td>${show.busFare}</td>
					<td><form action = "AirlineController?action=bookingTicket" method="post">
							<button type="submit">Book</button>
						</form> 
					</td>
				</tr>
			</s:forEach>
		</table>
</body>
</html>