<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Utente,model.UtenteDao,java.util.Collection"%>
<!DOCTYPE html>
<html>
<head>
<link href="./css/admin.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Admin - UniWarehouse</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<%@include file="topnav.jsp" %>
<%
	UtenteDao model = new UtenteDao();
	Collection<Utente> beans= model.doRetrieveAll("matricola");
%>

<div class="admincontainer">
<%
	for(Utente u : beans){
		if(u.getMatricola()!=su.getMatricola()){%>
		<div class="utente">
			<p>Matricola : <%=u.getMatricola() %> | Nome : <%=u.getNome() %> | Cognome : <%=u.getCognome() %> | E-Mail : <%=u.getEmail() %></p>
			<a class="bottonerimuovi" href="<%=response.encodeURL("Rimuovi_Profilo?id=" + u.getMatricola())%>">Rimuovi Profilo</a>
		</div>
	<%}
	}
%>

</div>
	<%@include file="footer.jsp" %>
</body>
</html>