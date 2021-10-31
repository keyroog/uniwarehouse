<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Wishlist"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession ssn= request.getSession();
	Wishlist list = (Wishlist)ssn.getAttribute("wishlist");
	if(list==null){%>
		<h1>Non c'e nulla</h1>
<%}else{
	list.toString();}%>
</body>
</html>