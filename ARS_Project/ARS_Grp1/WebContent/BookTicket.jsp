<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookTicket</title>
 <link rel='stylesheet' type='text/css' href='stylesheet.css'/>
        <link rel='stylesheet' type='text/css' href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css'/>
        <script type='text/javascript' src='script.js'></script>

</head>
<body>

<form action="AirlineController?action=showAvailFlights" method="post">
	<h2 align="center">Book Ticket</h2>
	<table align="center">
		<tr>
			<td><label>Enter source city:</label></td>
			<td><select name="source">
					<option value="Mumbai">Mumbai
					<option value="Bangalore">Bangalore
					<option value="Delhi">Delhi
					<option value="Chennai">Chennai
					<option value="Kolkata">Kolkata
					<option value="Hyderabad">Hyderabad
				  </select></td>
		</tr>
		<tr>
			<td><label>Enter destination city:</label></td>
			<td><select name="destination">
					<option value="Mumbai">Mumbai
					<option value="Bangalore">Bangalore
					<option value="Delhi">Delhi
					<option value="Chennai">Chennai
					<option value="Kolkata">Kolkata
					<option value="Hyderabad">Hyderabad
				  </select></td>
		</tr>
		<tr>
			<td><label>Enter departure date:</label></td>
			
			<td><input type="text" name="departingDate"/></td>
        </tr>
			
			
			<!--  <td><input type="date" name="date"  required></td> --> 
		
		<tr>
			<td><label>Enter number of passengers:</label></td>
			<td><input type="number" name="noOfPassengers"  required></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="submit">Show Available Flight</button></td>
		</tr>
		</table>
</form>
</body>
</html>