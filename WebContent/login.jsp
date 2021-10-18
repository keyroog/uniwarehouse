<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - UniWarehouse</title>
<link href="./css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
		<%@include file="header.jsp" %>
	<div class= form_container>
	<fieldset>
	<legend>ACCEDI</legend>
		<form class=Accedi action=Login method="post">
			<input type="text" placeholder="Email" name="email" required> <br>
			<input type="password" placeholder="Password" name="password" required> <br>
		</form>
	</fieldset>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>