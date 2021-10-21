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
</head>
<body>
	<%@include file="header.jsp" %>
	<table>
	<tr>
		<th>Codice</th>
		<th>Nome</th>
		<th>Descrizione</th>
		<th>Data Inserimento</th>
		<th>Immagine</th>
	</tr>
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
				<td><img src="./getPicture?id=1 " onerror="this.src='./imgs/nophoto.png'" style="width:100px"></td>
			</tr>
	<% 		} 
	 	} else { %>
	<tr>
		<td colspan="4">No product available</td>
	</tr>	
	<% } %>
</table>
	
	
	 <%@include file="footer.jsp" %>
</body>
</html>