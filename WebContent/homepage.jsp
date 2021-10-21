<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UniWareHouse</title>
<link href="./css/homepage.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="topnav">
  		<a href="#home">Home</a>
  		<a href="http://localhost/UNIWAREHOUSE/annuncio.jsp">Vendi</a>
  		<a href="http://localhost/UNIWAREHOUSE/Catalogo.jsp">Compra</a>
  		<a href="#about">FAQ</a>
  		<a href="#about">Account</a>
	</div>
	
	<div class="boxsearch">
		<form class="searchbar" action="action_page.php">
  			<input type="text" placeholder="Cerca il tuo libro.." name="search">
  			<button type="submit"> Cerca </button>
		</form>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>