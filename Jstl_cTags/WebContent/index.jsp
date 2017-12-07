<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="<h1>hello</h1>" escapeXml="false"></c:out>
<%
int arr[]={1,2,3,4,5};
request.setAttribute("array",arr);
%>
<c:set var="arrayName" value="${array}" /> 
<c:set var="myVal" value="hello welcome" scope="session"/>

value is ${myVal}
<br>
value of array

${arrayName}
${arrayName[0]}
${arrayName[2]}


<form action="control.do">
<input type="text" name="name"/>
<input type="text" name="pass"/>
<input type="submit" value="store"/>
</form>

<c:url value="process.do" var="url"></c:url>

<a href="${url}">view all Users</a>






</body>
</html>