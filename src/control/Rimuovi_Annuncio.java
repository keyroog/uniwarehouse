package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.AnnuncioDAO;

/**
 * Servlet implementation class Rimuovi_Annuncio
 */
@WebServlet("/Rimuovi_Annuncio")
public class Rimuovi_Annuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rimuovi_Annuncio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnnuncioDAO model = new AnnuncioDAO();
		int id = Integer.parseInt(request.getParameter("annuncio"));
		try {
			model.doDelete(id);
		} catch (SQLException e) {
			e.printStackTrace(); //pagina qualcosa è andato storto
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homepage.jsp");
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
