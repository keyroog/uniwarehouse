package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Annuncio;
import model.AnnuncioDAO;

/**
 * Servlet implementation class Catalogo_Servlet
 */
@WebServlet("/Catalogo_Servlet")
public class Catalogo_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Catalogo_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnuncioDAO model = new AnnuncioDAO();
		Collection<Annuncio> catalog;
		try {
			catalog = (Collection<Annuncio>) model.doRetrieveAll("idannuncio");
			if(catalog.isEmpty()) {
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ErrorPages/catalogoVuoto.jsp");
				dispatcher.forward(request, response);
			}
			
			
			request.setAttribute("catalogo", catalog);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/catalogo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
