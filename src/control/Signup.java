package control;
import model.UtenteDao;
import utilities.Validator;

import java.io.IOException;
import java.sql.SQLException;
import model.Utente;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductControl
 */

@WebServlet("/Signup")

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accessonegato.jsp");
		int error=0;
		
		UtenteDao dao = new UtenteDao();
		
		Utente model = new Utente();
		model.setMatricola(Integer.parseInt(request.getParameter("matricola")));
		
		String nome =  request.getParameter("nome");
		try {
			nome = Validator.checkNome(nome);
			model.setNome(nome);
		}catch (Exception e) {
			error=1;
			request.setAttribute("errore-registrazione", error);
			dispatcher.forward(request, response);
			return;
		}
		model.setCognome(request.getParameter("cognome"));
		model.setEmail(request.getParameter("email"));
		model.setTipolaurea(request.getParameter("tipolaurea"));
		model.setDipartimento(request.getParameter("dipartimento"));
		model.setCellulare(request.getParameter("cellulare"));
		model.setPass(request.getParameter("password"));
		
		
		
		try {
			dao.doSave(model);
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

