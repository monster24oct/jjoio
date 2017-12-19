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
<form action = "AirlineController?action=addPassenger" method="post">
<TABLE border="1">
<tr>
    <th>UserId</th>
    <th>FlightID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    </tr>
    <tr>
    <td><input type="text" name="UserId" value="${userId}"></td>
    <td><input type="text" name="FlightID"></td>
    <td><input type="text" name="Name"></td>
    <td><input type="text" name="Age"></td>
    <td><input type="text" name="Gender"></td>
  </tr>
</TABLE>
<button type="submit">Add User</button>
</form>
<form action = "AirlineController?action=success" method = "post">
	<button> Submit </button>
</form>
</body>
</html>