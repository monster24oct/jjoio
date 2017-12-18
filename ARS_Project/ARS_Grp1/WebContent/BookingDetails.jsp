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
<form action = >
<TABLE border="1">
<tr>
    <th>UserId</th>
    <th>Flight ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    </tr>
    
<%
int records=noOfPassengers;
for(int row=1; row <= records; row++) { %>
    <tr>
    <td><input type="text" value="${userId}"></td>
    <td><input type="text"></td>
    <td><input type="text"></td>
    <td><input type="text"></td>
    <td><input type="text"></td>
    </tr>
<% } %>
</TABLE>
</form>>
</body>
</html>