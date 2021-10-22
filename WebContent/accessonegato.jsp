<%@ page isErrorPage="true" %>  
<head>
<link href="./css/accessonegato.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="accessdenied">
<fieldset>
<legend>Errore di registrazione</legend>

<%
	int errore = (int)request.getAttribute("errore-registrazione");
	if(errore==1){
%>	<a>Il nome non puo contenere numeri o caratteri speciali </a><%} %>

</fieldset>
</div>

<%@include file="footer.jsp" %>
</body>