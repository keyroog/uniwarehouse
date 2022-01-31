<%@ page isErrorPage="true" %>  
<head>
<title>Errore Modifica - UniWarehouse</title>
<link href="./css/accessonegato.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="accessdenied">
<fieldset>
<legend>Errore di Modifica</legend>

<%int errore = (int)request.getAttribute("errore-modifica");%>
<%	if(errore==1){ %>
	<h1>Il prezzo non può essere negativo </h1>
<%	} %>
<%	if(errore==2){ %>
	<h1>Formato Prezzo Non Valido </h1>
<%	} %>
<%	if(errore==3){ %>
	<h1>Le password non corrispondono </h1>
<%	} %>
<a href="./impostazioni.jsp" class="button">RIPROVA</a>
</fieldset>
</div>

<%@include file="../footer.jsp" %>
</body>