<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="./css/landing.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>uniWarehouse</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="descrizione">
		<h1>Benvenuto sulla piattaforma uniWarehouse.</h1>
		<p>Qui avrai la possibilità di acquistare e vendere testi di seconda mano in modo facile e veloce</p>
		<img src="./images/logoo.png">
		<br>
		<br><br><br>
		<a href="<%=response.encodeURL("login.jsp")%>">Accedi</a>
		<a href="<%=response.encodeURL("sign_up.jsp")%>">Registrati</a>
		<br><br><br>
	</div>


	<%@include file="footer.jsp" %>
</body>
</html>