<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.Utente"%>
<!DOCTYPE html>
<html>
<head>
<link href="./css/user.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Profilo Utente - UniWarehouse</title>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="topnav.jsp" %>
	<div class="profile">
		<fieldset>Nome : <%=su.getNome() %></fieldset>  <button> Modifica </button>
		<fieldset>Cognome : <%=su.getCognome() %></fieldset>  <button> Modifica </button> 
		<fieldset>email : <%=su.getEmail() %> </fieldset>  <button> Modifica </button>
		<fieldset>Matricola : <%=su.getMatricola() %> </fieldset>  <button> Modifica </button>
		<fieldset>Password : ******** </fieldset>  <button> Modifica </button> 
		<fieldset>Dipartimento : <%=su.getDipartimento() %>  </fieldset>  <button> Modifica </button>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>