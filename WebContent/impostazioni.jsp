<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Impostazioni - UniWarehouse</title>
<link href="./css/impostazioni.css" rel="stylesheet" type="text/css">
</head>
<body>

<%@include file="header.jsp" %>
<%@include file="topnav2.jsp" %>


<div id="demo">
<fieldset>
	<legend>IMPOSTAZIONI</legend>
	<button type="button" onclick="loadDoc()">Informazioni Utente</button>
	<button type="button" onclick="loadDoc2()">I Miei Annunci</button>
	</fieldset>
</div>

<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML =
      this.responseText;
    }
  };
  xhttp.open("GET", "user.jsp", true);
  xhttp.send();
}

function loadDoc2() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("demo").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("GET", "Annunci_Utente", true);
	  xhttp.send();
	}
</script>

<%@include file="footer.jsp" %>
</body>
</html>