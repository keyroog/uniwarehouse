<!DOCTYPE html>
<%@ page import="java.util.*, autenticazione.Utente"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  margin-top:0px;
  background-color: #ff4461;
  overflow: hidden;
}

.topnav a {
  float: left;
  color: white;
  text-align: center;
  padding: 15px 6%;
  text-decoration: none;
  font-size: 12px;
  margin:0;
}

.topnav a:hover {
  background-color: #ff9900;
  color: white;
  opacity: 0.7;
}

.topnav a.active {
  background-color: #ff9900;
  color: white;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}
</style>
</head>
<body>

	<%
		Utente su = new Utente();
		HttpSession ssnn = request.getSession();
		su = (Utente) ssnn.getAttribute("user");
		if(su==null){
			getServletContext().getRequestDispatcher("/landing.jsp").forward(request, response);
		}
	%>

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
  		<a href="<%=response.encodeURL("Logout_Servlet")%>">LogOut</a>
  		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    		<i class="fa fa-bars"></i>
  		</a>
	</div>

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

</body>
</html>