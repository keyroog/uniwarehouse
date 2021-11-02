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
	<%@include file="topnav.jsp" %>
	<div class= form_container>
	<fieldset>
	<legend>PUBBLICA UN ANNUNCIO</legend>
		<form class=Annuncio action=Annuncio_Servlet method="post" enctype="multipart/form-data">
			<input type="text" placeholder="nomelibro" name="libro" required> <br>
			<textarea name="descrizione" placeholder="Scrivi una breve descrizione del libro..." rows="10" cols="50"></textarea> <br>
			<input class="file" type="file" name="talkPhoto" value="" maxlength="255">	<br>
			<input type="text" placeholder="Prezzo " name="prezzo" required> <br>
			<select id="dipartimento" name="dipartimento">
	    					<option value="informatica">Informatica</option>
	    					<option value="ingegneria">Ignegneria</option>
	    					<option value="economia">Economia</option>
	    					<option value="chimica">Chimica</option>
	  		</select><br><br>
			<input type="submit" class="bottonesubmit"value="Pubblica">
		</form>
	</fieldset>
	</div>
 	<%@include file="footer.jsp" %>
</body>
</html>