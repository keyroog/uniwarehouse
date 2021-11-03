<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Annuncio,model.AnnuncioDAO,model.Utente,model.UtenteDao"%>

 
<!DOCTYPE html>
<html>
<head>
<% 
	Annuncio bean = new Annuncio();
	AnnuncioDAO model = new AnnuncioDAO();
	String id=request.getParameter("id");
	UtenteDao model2 = new UtenteDao();
	bean = (Annuncio) model.doRetrieveById(id);
	Utente user = model2.doRetrieveByKey(bean.getFkannuncio());
%>
<link href="./css/post.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title><%=bean.getNomeLibro()%> - UniWarehouse</title>
</head>
<body>
		<%@include file="header.jsp" %>
		<%@include file="topnav2.jsp" %>
		<div class="grid product">
      <div class="column-xs-12 column-md-7">
        <div class="product-gallery">
          <div class="product-image">
            <img class="active" src="./getPicture?id=<%=id%> " onerror="this.src='./imgs/nophoto.png'" style="width:100px">
          </div>
        </div>
      </div>
      <div class="column-xs-12 column-md-5">
        <h1><%=bean.getNomeLibro() %></h1>
        <h1><%=bean.getPrice() %> Euro</h1>
        <div class="description">
        	<p>DESCRIZIONE</p>
          <p class="descrizione"><%=bean.getDescrizione() %></p>
          <p>VENDITORE</p>
          <p class="venditore"><%=bean.getNome() %> <%=bean.getCognome() %></p>
        </div>
        <a class="bottoneaggiungi" href="https://wa.me/+39<%=user.getCellulare()%>?text=Sarei%20interessato%20al%20tuo%20annuncio">Contattami</a>
        <a class="bottoneaggiungi" href="<%=response.encodeURL("ProductControl?action=addCart&id=" + bean.getId())%>">Aggiungi Alla Wishlist</a>
      </div>
    </div>
		
		<%@include file="footer.jsp" %>

</body>
</html>