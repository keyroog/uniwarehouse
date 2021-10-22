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
<link href="./css/catalogo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="header.jsp" %>
	<%@include file="topnav.jsp" %>
	<table class="catalog">
	<tr>
		<th>Codice</th>
		<th>Nome</th>
		<th>Descrizione</th>
		<th>Data Inserimento</th>
		<th>Immagine</th>
		<th>Prezzo</th>
		<th>Venditore<th>
	</tr>
	<tbody>
	<%
		if(products != null && products.size() > 0) {
			
			Iterator<?> it  = products.iterator();
			while(it.hasNext()) {
				Annuncio bean = (Annuncio) it.next();
	%>
			<tr>
				<td><%=bean.getId()%></td>
				<td><%=bean.getNomeLibro()%></td>
				<td><%=bean.getDescrizione()%></td>
				<td><%=bean.getDate()%></td>
				<td><img src="./getPicture?id=<%=bean.getId() %> " onerror="this.src='./imgs/nophoto.png'" style="width:100px"></td>
				<td><%=bean.getPrice() + "&euro;"%></td>
				<td><%=bean.getNome() + " " + bean.getCognome()%></td>
			</tr>
	<% 		} 
	 	} else { %>
	<tr>
		<td colspan="4">No product available</td>
	</tr>	
	<% } %>
	</tbody>
</table>
	
	
	 <%@include file="footer.jsp" %>
</body>
</html>