<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.Annuncio"%>
<%
 	Collection<?> products = (Collection<?>) request.getAttribute("catalogo");
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo - UniWarehouse</title>
<link href="./css/annunci_utente.css" rel="stylesheet" type="text/css">
</head>
<body>


<h1 class="titolo"> I Miei Annunci </h1>
	
<div class = "container">
		<%
		if(products != null && products.size() > 0) {
			
			Iterator<?> it  = products.iterator();
			while(it.hasNext()) {
				Annuncio bean = (Annuncio) it.next();
	%>

				<div class="card">
  					<img src="./getPicture?id=<%=bean.getId() %> " onerror="this.src='./imgs/nophoto.png'" style="width:100px">
  					<h1><%=bean.getNomeLibro()%></h1>
  					<p class="price"><%=bean.getPrice() + "&euro;"%></p>
 					<%String length=bean.getDescrizione();
 						if(length.length()>30){
 							length=length.substring(0,29);
 							length+="...";
 						}%>
 					<p><%=length%></p>
 					<p><%=bean.getDate()%></p>
 					<p><%=bean.getNome() + " " + bean.getCognome()%></p>
 					<button onclick="location.href='http://localhost:8080/UNIWAREHOUSE/modificaannuncio.jsp'">Modifica Annuncio</button>
 					<form action="Rimuovi_Annuncio" method="post">
 						<input type="hidden" name="annuncio" value=<%=bean.getId()%>>
 						<input type="submit" value="Rimuovi Annuncio">
 					</form>
				</div>

	<% 		} 
	 	} else {
			getServletContext().getRequestDispatcher("/ErrorPages/catalogoVuoto.jsp").forward(request, response);
	 } %>
		
</div>
</body>
</html>