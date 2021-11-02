<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.Annuncio, model.UtenteDao"%>
<%
	ServletContext ctx = getServletContext();
 	Collection<?> products = (Collection<?>) ctx.getAttribute("catalogo");
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo - UniWarehouse</title>
<link href="./css/catalogo.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%@include file="header.jsp" %>
	<%@include file="topnav.jsp" %>

	
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
  					<% Utente user = new Utente();
 					UtenteDao userdao = new UtenteDao();
 					user = (Utente) userdao.doRetrieveByKey(bean.getFkannuncio());
 					%>
  					<a class="bottoneaggiungi" href="https://wa.me/+39<%=user.getCellulare()%>?text=Sarei%20interessato%20al%20tuo%20annuncio">Contattami</a>
  					<a class="bottoneaggiungi" href="<%=response.encodeURL("ProductControl?action=addCart&id=" + bean.getId())%>">Aggiungi Alla Wishlist</a>
				</div>

	<% 		} 
	 	} else {
			getServletContext().getRequestDispatcher("/ErrorPages/catalogoVuoto.jsp").forward(request, response);
	 } %>
		
</div>
	 <%@include file="footer.jsp" %>
</body>
</html>