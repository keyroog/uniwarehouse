<%@ page isErrorPage="true" %>  
<head>
<link href="./css/accessonegato.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="accessdenied">
<fieldset>
<legend>Errore di reimpostazione</legend>

<%int errore = (int)request.getAttribute("errore-reimpostazione");%>
<%	if(errore==4){ %>
	<h1>La nuova password non ha un formato valido </h1>
<%	} %>
<%	if(errore==5){ %>
	<h1>Le password non corrispondono </h1>
<%	} %>
<a href="./impostazioni.jsp" class="button">RIPROVA</a>
</fieldset>
</div>

<%@include file="../footer.jsp" %>
</body>