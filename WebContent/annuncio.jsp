<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annuncio - UniWarehouse</title>
<link href="./css/annuncio.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class= form_container>
	<fieldset>
	<legend>PUBBLICA UN ANNUNCIO</legend>
		<form class=Annuncio action=Annuncio method="post">
			<input type="text" placeholder="nome libro" name="libro" required> <br>
			<textarea name="descrizione" placeholder="Scrivi una breve descrizione del libro..." rows="10" cols="50"></textarea> <br>
			<input type="text" placeholder="inserisci url foto" name="link"> <br>
			<input type="submit" value="Pubblica">
		</form>
	</fieldset>
	</div>
 	<%@include file="footer.jsp" %>
</body>
</html>