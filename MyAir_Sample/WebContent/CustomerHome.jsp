<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home !!!</title>
</head>
<body>
<h2 align="center">MyAir Telecommunication</h2>
<h2>Welcome ${beans.userName}</h2>
<b>The pending bill amount for your Mobile number</b>
<br>
${beans.mobileNumber} is Rs.750
<br>
<form action="ProcessUser?action=pay" method="post">
<p align="center" ><button type="submit">Pay Bill</button></p>
</form>
<a href="ProcessUser?action=home">Home</a>
</body>
</html>