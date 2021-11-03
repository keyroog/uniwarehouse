<%@ page import="java.util.*, model.Utente"%>
<link href="./css/header.css" rel="stylesheet" type="text/css">
	<%
		Utente su = new Utente();
		HttpSession ssnn = request.getSession();
		su = (Utente) ssnn.getAttribute("user");
		if(su==null){
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	%>
	<script>
		function myFunction() {
		  var x = document.getElementById("myTopnav");
		  if (x.className === "topnav") {
		    x.className += " responsive";
		  } else {
		    x.className = "topnav";
		  }
		}
	</script>
	<div class="topnav" id="myTopnav">
		<%
		Boolean adminRoles = (Boolean) ssnn.getAttribute("adminRoles");
		if ((adminRoles != null) && (adminRoles==true))
		{%>
		<a href="http://localhost:8080/UNIWAREHOUSE/admin.jsp">Admin</a>
		<%}%>
  		<a href="http://localhost:8080/UNIWAREHOUSE/homepage.jsp" class="active">Home</a>
  		<a href="http://localhost:8080/UNIWAREHOUSE/annuncio.jsp">Vendi</a>
  		<a href="http://localhost:8080/UNIWAREHOUSE/Catalogo_Servlet">Compra</a>
  		<a href="http://localhost:8080/UNIWAREHOUSE/wishlist.jsp">Wishlist</a>
  		<a href="http://localhost:8080/UNIWAREHOUSE/impostazioni.jsp"><%=su.getNome().toUpperCase() %></a>
  		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    		<i class="fa fa-bars"></i>
  		</a>
	</div>
