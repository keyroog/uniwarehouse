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
		<fieldset>Nome : <%=su.getNome() %></fieldset>
		<fieldset>Cognome : <%=su.getCognome() %></fieldset>
		<fieldset>email : <%=su.getEmail() %> </fieldset>
		<fieldset>Matricola : <%=su.getMatricola() %> </fieldset> 
		<fieldset>Password : <%= su.getPass() %> </fieldset>
		<fieldset>Dipartimento : <%=su.getDipartimento() %>  </fieldset> 
		<button onclick="location.href='http://localhost:8080/UNIWAREHOUSE/modificapassword.jsp'"> Modifica Password </button>
	</div>
</body>
</html>