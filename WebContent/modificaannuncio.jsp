<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="interazione_annunci.Wishlist,annunci.Annuncio,annunci.AnnuncioDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annuncio - UniWarehouse</title>
<link href="./css/annuncio.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%
		String id = request.getParameter("id");
		AnnuncioDAO model=new AnnuncioDAO();
		Annuncio bean = model.doRetrieveById(id);
	%>
	
	<%@include file="header.jsp" %>
	<%@include file="topnav2.jsp" %>
	<div class= form_container>
	<fieldset>
	<legend>Modifica Annuncio</legend>
		<form class=Annuncio action="Modifica_Annuncio" method="post">
			<div class="imagecontainer">
				<img class="image"src="./getPicture?id=<%=bean.getId() %> " onerror="this.src='./imgs/nophoto.png'" style="width:100px">
			</div>
			<input type="hidden" name="id" value="<%=bean.getId()%>">
			<input type="text"  name="libro" value="<%=bean.getNomeLibro() %>" required> <br>
			<textarea name="descrizione" rows="10" cols="50" required><%=bean.getDescrizione() %></textarea> <br>
			<input type="text" value="<%=bean.getPrice()%>" name="prezzo" required> <br>
			<input type="submit" id="bottonemodifica" value="Modifica">

		</form>
	</fieldset>
	</div>
 	<%@include file="footer.jsp" %>
</body>
</html>