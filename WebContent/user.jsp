<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.Utente"%>
<!DOCTYPE html>
<html>
<head>
<link href="./css/user.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Profilo Utente - UniWarehouse</title>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="topnav.jsp" %>
	<div class="profile">
		Nome : <%=su.getNome() %>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>