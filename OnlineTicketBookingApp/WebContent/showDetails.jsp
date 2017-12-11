<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
				<td>Movie Name</td>
				<td>Location</td>
				<td>Date</td>
				<td>Price</td>
				<td>Available Seats</td>
				<td>Book</td>
			</tr>
			
			<s:forEach var="show" items="${showList}">
				<tr>
					<td>${show.showName}</td>
					<td>${show.location}</td>
					<td>${show.showDate}</td>
					<td>${show.price}</td>
					<td>${show.availableSeats}</td>
					<s:choose>
						<s:when test="${show.availableSeats != 0}">
							<td><a href="./getShowDetails?showid=${show.showId}">Book</a></td>
						</s:when>
						<s:when test="${show.availableSeats == 0}">
							<td><b>Sold</b></td>
						</s:when>
					</s:choose>
				</tr>
			</s:forEach>
		</table>
	</body>
</html>