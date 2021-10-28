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
	<%
		Utente su = new Utente();
		HttpSession ssnn = request.getSession();
		su = (Utente) ssnn.getAttribute("user");
		if(su==null){
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}else
	%>
	<div class="profile">
		<h1> Informazioni di Contatto </h1>
		<fieldset>Nome : <%=su.getNome() %></fieldset>  <button> Modifica </button>
		<fieldset>Cognome : <%=su.getCognome() %></fieldset>  <button> Modifica </button> 
		<fieldset>email : <%=su.getEmail() %> </fieldset>  <button> Modifica </button>
		<fieldset>Matricola : <%=su.getMatricola() %> </fieldset>  <button> Modifica </button>
		<fieldset>Password : ******** </fieldset>  <button> Modifica </button> 
		<fieldset>Dipartimento : <%=su.getDipartimento() %>  </fieldset>  <button> Modifica </button>
	</div>
</body>
</html>