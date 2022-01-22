<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="./script/formValidation.js"></script>
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
<meta charset="ISO-8859-1">
<title>Sign Up - UniWarehouse</title>
<link href="./css/sign_up.css" rel="stylesheet" type="text/css">
</head>
<body onload="document.registra.nome.focus();">
	<%@include file="header.jsp" %>
	<div class="searchbox">
	<div class="form_container">
		<h1>Registrati Per Proseguire</h1>
			<form class="registra" id="registra"  name="registra" action="Signup" method="post"  onsubmit="return validateForm();">
				<input type="text"  placeholder="nome" name="nome" size="12"><br>
				<input type="text" placeholder="cognome" name="cognome" ><br>
				<input type="email" placeholder="e-mail" name="email" > <br>
				<input type="password" id="password" placeholder="password" name="password" onkeyup="check();" ><br>
				<input type="password" id="conferma_password" placeholder="conferma password" name="conferma_password" onkeyup="check();" ><br>
				<div class="message" id="message"> </div> <br>
				<input type="text" placeholder="Matricola" name="matricola" class="matricola"><br>
				<input type="tel" placeholder="Cellulare" name="cellulare" ><br>
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
				<input type="reset" class="bottonesubmit" value="Reset">
				<input type="submit" class="bottonesubmit" value="conferma">
				</h1>
			</form>
			</div>
		<h1 class="login">Oppure <a class="bottone" href="./login.jsp">Accedi</a></h1>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>