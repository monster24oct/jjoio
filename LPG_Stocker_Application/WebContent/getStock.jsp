<%@page import="com.cg.lpg.bean.LPGStockBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>
<br><br>
<table border="2">
		<tr>
			<th><label>Available Stock</label></th>
			<th><label>LPG Provider</label></th>
			<th><label>Location</label></th>
			<th><label>Show Consumption</label></th>
		</tr>


		<c:forEach items="${list}" var="details">
		
			<tr>
				<td>${details.avQty}</td>
				<td>${details.updatedBy}</td>
				<td>${details.location}</td>
				<c:if test="${details.avQty > 0}">
				<td><a
					href="LPGController?action=updateForm&provider=${details.updatedBy}&qty=${details.avQty}">Consumer Now</a></td>
				</c:if>
				<c:if test="${details.avQty == 0}">
				<td>NO LPG STOCK</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="index.jsp">Back</a>
</body>
</html>