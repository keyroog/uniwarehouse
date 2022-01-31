<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,annunci.Annuncio"%>
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
 						if(length.length()>23){
 							length=length.substring(0,22);
 							length+="...";
 						}%>
 					<p><%=length%></p>
 					<p><%=bean.getDate()%></p>
 					<p><%=bean.getNome() + " " + bean.getCognome()%></p>
 					<a class="bottoneaggiungi" href="<%=response.encodeURL("modificaannuncio.jsp?id=" + bean.getId())%>">Modifica Annuncio</a>
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