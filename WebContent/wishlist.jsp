<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Wishlist,model.Annuncio,java.util.Collection,java.util.List"%>
    
     <%

 	@SuppressWarnings("unchecked")
 	Wishlist<Annuncio> cart = (Wishlist<Annuncio>)request.getSession().getAttribute("carrello");
	
 	if(cart == null) {
 		response.sendRedirect(response.encodeRedirectURL("./ErrorPages/wishlistvuota.jsp"));
 		return;
 	}	
 	int i=0;	
 %>   
<!DOCTYPE html>
<html>
<head>
<link href="./css/wishlist.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Wishlist - Uniwarehouse</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<%@include file="topnav.jsp" %>
<%
	List<Annuncio> prodcart = cart.getItems();

	if(prodcart.size() > 0) {}
	else{	 		
		response.sendRedirect(response.encodeRedirectURL("./ErrorPages/wishlistvuota.jsp"));
		return;}
	%>
		<h1 class="titolo">Wishlist</h1>
	<%
		if(prodcart.size() > 0) {
			for(Annuncio prod: prodcart) {
	%>
	
<div class="shopping-cart">
 
  <div class="item">
    <div class="buttons">
      <a href="<%=response.encodeURL("ProductControl?action=delete&id=" + i)%>"><img class="delete-btn" src="./images/delete.png"></a>
    </div>
 
    <div class="image">
     <img src="./getPicture?id=<%=prod.getId() %> " onerror="this.src='./imgs/nophoto.png'" style="width:100px">
    </div>
 
    <div class="description">
      <span><%=prod.getNomeLibro()%></span>
      <span><%=prod.getDescrizione()%></span>
    </div>
 

 
    <div class="total-price"><%=prod.getPrice()%> Euro</div>
  </div>
</div>


	<% 	i++;	}
		} else {
	%>
		No product available in the cart
	<%
		}
	%>
<%@include file="footer.jsp" %>
</body>
</html>