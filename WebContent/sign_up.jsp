<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up - UniWarehouse</title>
<link href="./css/sign_up.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="searchbox">
	<div class="form_container">
		<h1>Registrati Per Proseguire</h1>
			<form class="registra" action="Signup" method="post">
				<input type="text"  placeholder="nome" name="nome"  required><br>
				<input type="text" placeholder="cognome" name="cognome" required><br>
				<input type="email" placeholder="e-mail" name="email" required> <br>
				<input type="password" id="password" placeholder="password" name="password" onkeyup="check();" required><br>
				<input type="password" id="conferma_password" placeholder="conferma password" name="conferma_password" onkeyup="check();" required><br>
				<div class="message" id="message"></div> <br>
				<input type="text" placeholder="Matricola" name="matricola" class="matricola"required><br>
				<input type="tel" placeholder="Cellulare" name="cellulare" required><br>
				<fieldset>
					<legend>Il Tuo Profilo</legend>
						<label for="dipartimento">Seleziona Il Dipartimento:</label>
	  					<select id="dipartimento" name="dipartimento">
	    					<option value="informatica">Informatica</option>
	    					<option value="ingegneria">Ignegneria</option>
	    					<option value="economia">Economia</option>
	    					<option value="chimica">Chimica</option>
	  					</select><br><br>
	  						<br><br>
	  						<label for="tipolaurea">Seleziona Il tipo di laurea:</label>
	  					<select id="tipolaurea" name="tipolaurea">
	    					<option value="triennale">triennale</option>
	    					<option value="magistrale">magistrale</option>
	  					</select><br><br>
				</fieldset>
				<h1 class="invio">
				<input type="reset" value="Reset">
				<input type="submit" value="conferma">
				</h1>
			</form>
			</div>
		<script>
		var check = function() {
		      if (document.getElementById("password").value ==
		          document.getElementById("conferma_password").value) {
		          document.getElementById("message").style.color = "green";
		          document.getElementById("message").innerHTML = "Coincidono";
		      } else {
		      		document.getElementById("message").style.color = "red";
		          document.getElementById("message").innerHTML = "Non Coincidono";
		      }
		  }
		
		</script>
		<h1 class="login">Oppure <a href="" target="_blank">Accedi</a></h1>
	</div>
</body>
</html>