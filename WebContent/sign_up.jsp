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
	<header>
		<img class="logo" src="./images/logo.png">
			<h1>UniWarehouse</h1>
	</header>
	<div class="searchbox">
		<h1>Registrati Per Proseguire</h1>
		<form class="registra" action="" method="post">
			<input type="text"  placeholder="nome" name="nome"  required>
			<input type="text" placeholder="cognome" name="cognome" required>
			<input type="email" placeholder="e-mail" name="email" required> <br><br><br><br>
			<input type="password" id="password" placeholder="password" name="password" onkeyup="check();" required>
			<input type="password" id="conferma_password" placeholder="conferma password" name="conferma_password" onkeyup="check();" required>
			<span id="message"></span> <br><br><br><br>
			<input type="text" placeholder="Matricola" name="matricola" required>
			<fieldset>
				<legend>Il Tuo Profilo</legend>
					<label for="dipartimento">Seleziona Il Dipartimento:</label>
  					<select id="dipartimento" name="dipartimento">
    					<option value="volvo">Informatica</option>
    					<option value="saab">Ignegneria</option>
    					<option value="fiat">Economia</option>
    					<option value="audi">Chimica</option>
  					</select><br><br>
  						E Il tipo Di Laurea<br><br>
  						<input type="radio" id="html" name="fav_language" value="HTML">
  						<label for="html">Triennale</label><br>
  						<input type="radio" id="css" name="fav_language" value="CSS">
  						<label for="css">Magistrale</label><br>
			</fieldset>
			<h1 class="invio">
			<input type="reset" value="Reset">
			<input type="submit" value="conferma">
			</h1>
		</form>
		<script>
		var check = function() {
		      if (document.getElementById("password").value ==
		          document.getElementById("conferma_password").value) {
		          document.getElementById("message").style.color = "green";
		          document.getElementById("message").innerHTML = "Le Password Coincidono";
		      } else {
		      		document.getElementById("message").style.color = "red";
		          document.getElementById("message").innerHTML = "Le Password Non Coincidono";
		      }
		  }
		
		</script>
		<h1 class="login">Oppure <a href="" target="_blank">Accedi</a></h1>
	</div>
</body>
</html>