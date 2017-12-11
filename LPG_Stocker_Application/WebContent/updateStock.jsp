<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LPGController?action=update" method="post">
<table>
<tr><td>Lpg provider  : </td><td><input type="text" name="provider" value="${provider}"></td></tr>
<tr><td>Available Qty : </td><td><input type="text" name="quantity" value="${availableQty}"></td></tr>
<tr><td>Enter Qty to consume : </td><td><input type="number" name="requiredQty" pattern=[0-9]{1,}" max="${availableQty}" min="1"></td> 
<td><button type="submit">Update Stock</button></td></tr>
</table>
</form>
<br>
	<a href="getStock.jsp">Back</a>
</body>
</html>