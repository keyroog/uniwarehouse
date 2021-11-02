<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Utente,java.util.*, model.Annuncio, model.UtenteDao"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="ISO-8859-1">
<title>UniWareHouse</title>
<link href="./css/homepage.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
	ServletContext ctx = getServletContext();
 	Collection<?> products = (Collection<?>) ctx.getAttribute("catalogo");
 	int b;
 	b=(Integer)ctx.getAttribute("cambio");
 	if(b==1){
 		%><jsp:forward page="/Catalogo_Homepage" /><%
 	}
 %>
	<%@include file="header.jsp" %>
	<%@include file="topnav.jsp" %>
	<div class="boxsearch">
		<form class="searchbar" action="Cerca_Servlet" method=get>
  			<input type="text" placeholder="Cerca il tuo libro.." name="search">
  			<button type="submit"> Cerca </button>
		</form>
	</div>
		
<div class = "container">
		<%
		if(products != null && products.size() > 0) {
			int i=0;
			Iterator<?> it  = products.iterator();
			while(it.hasNext()&&i<3) {
				Annuncio bean = (Annuncio) it.next();
		%>
				<div class="card">
  					<img src="./getPicture?id=<%=bean.getId() %> " onerror="this.src='./imgs/nophoto.png'" style="width:100px">
  					<h1><%=bean.getNomeLibro()%></h1>
  					<p class="price"><%=bean.getPrice() + "&euro;"%></p>
 					<%String length=bean.getDescrizione();
 						if(length.length()>20){
 							length=length.substring(0,19);
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

	<% 		i++;
			} 
	 	}  else{
	 		%><h1> Non c'e nulla da comprare</h1><%
	 	
	 	}%>
		
</div>
	<%@include file="logOut.jsp" %>
	<%@include file="footer.jsp" %>
</body>
</html>