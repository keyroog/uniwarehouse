package control;

import java.util.ArrayList;
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
 * Servlet implementation class Cerca_Servlet
 */
@WebServlet("/Cerca_Servlet")
public class Cerca_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cerca_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ricerca = request.getParameter("search");
		
		AnnuncioDAO model = new AnnuncioDAO();
		Collection<Annuncio> risultato=new ArrayList<Annuncio>();
		try {
			Collection<Annuncio> annunci = model.doRetrieveAll("idannuncio");
			if(!annunci.isEmpty()) {
				for(Annuncio x : annunci) {
					String nomelibro=x.getNomeLibro();
					if(nomelibro.contains(ricerca)||ricerca.contains(nomelibro)) {
						risultato.add(x);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession ssn = request.getSession();
		ssn.setAttribute("risultato", risultato);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/homepage.jsp");
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
