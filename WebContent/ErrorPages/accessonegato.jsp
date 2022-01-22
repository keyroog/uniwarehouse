<%@ page isErrorPage="true" %>  
<head>
<link href="./css/accessonegato.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../JSP/header.jsp" %>
<div class="accessdenied">
<fieldset>
<legend>Errore di registrazione</legend>

<%int errore = (int)request.getAttribute("errore-registrazione");%>
<%	if(errore==1){ %>
	<h1>Il nome non puo contenere numeri o caratteri speciali </h1>
<%	} %>
<%	if(errore==2){ %>
	<h1>Il cognome non puo contenere numeri o caratteri speciali </h1>
<%	} %>

<%	if(errore==3){ %>
	<h1>Il formato dell'email non e' valido </h1>
<%	} %>

<%	if(errore==4){ %>
	<h1>Il formato della password non e' valido </h1>
<%	} %>

<%	if(errore==5){ %>
	<h1>Le password non corrispondono </h1>
<%	} %>

<%	if(errore==6){ %>
	<h1>Il formato della matricola non e' corretto </h1>
<%	} %>

<%	if(errore==7){ %>
	<h1>Il formato del numero cellulare non è corretto </h1>
<%	} %>
<%	if(errore<=7){ %>
	<a href="./sign_up.jsp" class="button">RIPROVA</a>
<%	} %>

<%	if(errore==8){ %>
	<h1>Email o Password Errata </h1>
	<a href="./login.jsp" class="button">RIPROVA</a>
<%	} %>

</fieldset>
</div>

<%@include file="../JSP/footer.jsp" %>
</body>