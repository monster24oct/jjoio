<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Pay !!!</title>
</head>
<body>
<center>
<h2>MyAir Telecommunication</h2>
<h2 >Pay Bill</h2><br>
<b>Payment for mobile number ${beans.mobileNumber}</b><br>
<form action="ProcessUser?action=payment" method="post">
<table>
<tr>
	<td><label>Enter the amount to Pay </label></td>
	<td><input type="text" name="amount" pattern="[0-9]{1,3}" required title="Amount should not exceed 750"/></td>
</tr>
<tr>
<td colspan="2" align="center"><button type="submit">Pay</button></td>
</tr>
</table>

</form>

</center>
<a href="ProcessUser?action=home">Home</a>

</body>
</html>