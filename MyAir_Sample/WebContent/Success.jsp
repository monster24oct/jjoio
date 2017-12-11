<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success page !!!</title>
</head>
<body>
<center>
<h2>MyAir Telecommunication</h2>
<b>Thank You for Paying your Bill<br>
	Your Balance amount is ${750 - amt}
	Bill Pay date is <%= LocalDate.now() %></b>
</center>
<a href="ProcessUser?action=home">Home</a>

</body>
</html>