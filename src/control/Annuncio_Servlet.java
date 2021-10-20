package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AnnuncioDAO;
import model.Utente;
import model.Annuncio;

/**
 * Servlet implementation class Annuncio
 */
@WebServlet("/Annuncio_Servlet")
public class Annuncio_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Annuncio_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnnuncioDAO dao = new AnnuncioDAO();
		Annuncio model = new Annuncio();
		HttpSession ctx = request.getSession();
		Utente user = (Utente) ctx.getAttribute("user");
		model.setFkannuncio(user.getMatricola());
		model.setDate();
		model.setDescrizione(request.getParameter("descrizione"));
		model.setNomeLibro(request.getParameter("libro"));
		model.setImage(request.getParameter("link"));
		
		try {
			dao.doSave(model);
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homepage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}