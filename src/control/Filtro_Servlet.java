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
import javax.servlet.http.HttpSession;

import model.Annuncio;
import model.AnnuncioDAO;

/**
 * Servlet implementation class Filtro_Servlet
 */
@WebServlet("/Filtro_Servlet")
public class Filtro_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filtro_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession ssn  = request.getSession();
		AnnuncioDAO model = new AnnuncioDAO();
		Collection<Annuncio>catalog;
		try {
			if(action.equals("tutti")) {
				catalog = (Collection<Annuncio>) model.doRetrieveAll("idannuncio");
			}else {
				catalog = (Collection<Annuncio>) model.doRetrieveByDipartimento(action);
			}
			if(catalog.isEmpty()) {
				ssn.setAttribute("filtrovuoto","1");
			}
			ssn.setAttribute("catalogo",catalog);
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
