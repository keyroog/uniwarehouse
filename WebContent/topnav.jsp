<%@ page import="java.util.*, model.Utente"%>
<link href="./css/header.css" rel="stylesheet" type="text/css">
	<%
		Utente su = new Utente();
		HttpSession ssnn = request.getSession();
		su = (Utente) ssnn.getAttribute("user");
		if(su==null){
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}else
	%>
	<div class="topnav">
  		<a href="http://localhost/UNIWAREHOUSE/homepage.jsp">Home</a>
  		<a href="http://localhost/UNIWAREHOUSE/annuncio.jsp">Vendi</a>
  		<a href="http://localhost/UNIWAREHOUSE/Catalogo_Servlet">Compra</a>
  		<a href="#about">FAQ</a>
  		<a href="http://localhost/UNIWAREHOUSE/user.jsp"><%=su.getNome().toUpperCase() %></a>
	</div>