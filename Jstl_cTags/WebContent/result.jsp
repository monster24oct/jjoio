<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.cg.bean.*"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="data" value="${empCollect }"/>

<c:if test="${data eq null}">
	<h1>no records found !</h1>
</c:if>

<c:if test="${data ne null}">

<c:forEach var="myVar"  items="${data}"> 

	${myVar.userId}<br>
	${myVar.name}<br>
	${myVar.branch}<br>
	${myVar.city}<br>
	<a href="update.do?id=${myVar.userId}">update</a>
</c:forEach>


</c:if>

<c:forEach begin="1000" end="1006" var="my">

	value is ${my}

 </c:forEach>




<%-- <%
ArrayList<UserData>  aList=(ArrayList<UserData>)session.getAttribute("empCollect");

for(UserData emp:aList){
	out.println("name is : "+emp.getName()+"<br>");
	out.println("Id is : "+emp.getUserId()+"<br>");
	out.println("branch is : "+emp.getBranch()+"<br>");
	out.println("city is : "+emp.getCity()+"<br>");
}
%> --%>
</body>
</html>