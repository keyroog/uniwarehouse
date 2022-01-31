package interazione_annunci;

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

import autenticazione.Utente;
import annunci.AnnuncioDAO;
import annunci.Annuncio;

/**
 * Servlet implementation class Annunci_Utente
 */
@WebServlet("/Annunci_Utente")
public class Annunci_Utente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Annunci_Utente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ErrorPages/nessunAnnuncio.jsp");
		AnnuncioDAO model = new AnnuncioDAO();
		Collection<Annuncio> catalog;
		HttpSession ssn = request.getSession();
		Utente usr = (Utente) ssn.getAttribute("user");
		int matricola = usr.getMatricola();
		try {
			catalog = (Collection<Annuncio>) model.doRetrieveByKey(matricola);
			if(catalog.isEmpty()) {
				dispatcher.forward(request, response);
				return;
			}
			
			
			request.setAttribute("catalogo", catalog);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		dispatcher = this.getServletContext().getRequestDispatcher("/annunci_utente.jsp");
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