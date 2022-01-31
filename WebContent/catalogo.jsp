<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,annunci.Annuncio, autenticazione.UtenteDao"%>
<%
	ServletContext ctx = getServletContext();
	Collection<?> products = (Collection<?>)request.getSession().getAttribute("catalogo");
	if(products==null){
 		products = (Collection<?>) ctx.getAttribute("catalogo");
	}
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
	<%@include file="topnav2.jsp" %>
<div class="buttonscontainer">
	<a class="bottoneaggiungi"  href="<%=response.encodeURL("Filtro_Servlet?action=tutti")%>">Tutti</a>
	<a class="bottoneaggiungi"  href="<%=response.encodeURL("Filtro_Servlet?action=informatica")%>">Informatica</a>
	<a class="bottoneaggiungi"  href="<%=response.encodeURL("Filtro_Servlet?action=chimica")%>">Chimica</a>
	<a class="bottoneaggiungi"  href="<%=response.encodeURL("Filtro_Servlet?action=Economia")%>">Economia</a>
	<a class="bottoneaggiungi"  href="<%=response.encodeURL("Filtro_Servlet?action=Ingegneria")%>">Ingegneria</a>
</div>

	
<div class = "container">
		<%
		if(products != null && products.size() > 0) {
			
			Iterator<?> it  = products.iterator();
			while(it.hasNext()) {
				Annuncio bean = (Annuncio) it.next();
	%>

				<div class="card">
  					<img src="./getPicture?id=<%=bean.getId() %> " onerror="this.src='./imgs/nophoto.png'" style="width:100px">
  					<a class="post" href="<%=response.encodeURL("post.jsp?id=" + bean.getId())%>"><h1><%=bean.getNomeLibro()%></h1></a>
  					<p class="price"><%=bean.getPrice() + "&euro;"%></p>
  					<p class="price"><%=bean.getDipartimento()%></p>
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
	 		HttpSession ssn = request.getSession();
	 		String codice=(String)ssn.getAttribute("filtrovuoto");
	 		if(codice!=null && codice.equals("1")){
	 		%><h1 class="nessunlibro">Nessun libro di questa facolta</h1><%
	 		ssn.setAttribute("filtrovuoto", "0");
	 		}else{
				getServletContext().getRequestDispatcher("/ErrorPages/catalogoVuoto.jsp").forward(request, response);
	 		}
	 } %>
		
</div>
	 <%@include file="footer.jsp" %>
	 <%request.getSession().setAttribute("catalogo",null); %>
</body>
</html>