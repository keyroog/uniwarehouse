<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="./script/formValidation.js"></script>
<meta charset="ISO-8859-1">
<title>Modifica Password - UniWarehouse</title>
<link href="./css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
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
	<%@include file="header.jsp" %>
	<%@include file="topnav2.jsp" %>
	
	
	<div class="form_container">
	<fieldset>
	<legend>Modifica Password</legend>
		<form id=modifica name="modifica" class="pass_reset" action="Modifica_Password" method="post""> 
			<input type="password" id="oldpass" placeholder="password precedente" name="oldpass" required> <br>
			<input type="password" id="password" placeholder="nuova password" name="newpass" onkeyup="check();" required> <br>
			<input type="password" id="conferma_password" placeholder="conferma password" name="confirmpass" onkeyup="check();" required> <br>
			<div class="message" id="message"> </div> <br>
			<input type="submit" id=bottonemodifica class="bottonesubmit"value="conferma nuova password">
		</form>
	</fieldset>
	</div>
	
		<%@include file="footer.jsp" %>
</body>
</html>