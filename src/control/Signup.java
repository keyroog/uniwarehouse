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
		int error=0;
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorPages/accessonegato.jsp");
		
		UtenteDao dao = new UtenteDao();
		
		Utente model = new Utente();
		
		String nome = request.getParameter("nome");
		try {
			String name = Validator.checkNome(nome);
			model.setNome(name);
		}catch(Exception e) {
			error = 1;
			request.setAttribute("errore-registrazione", error);
			dispatcher.forward(request, response);
			return;
		}
		
		String cognome = request.getParameter("cognome");
		try {
			String surname = Validator.checkNome(cognome);
			model.setCognome(surname);
		}catch(Exception e) {
			error = 2;
			request.setAttribute("errore-registrazione", error);
			dispatcher.forward(request, response);
			return;
		}
		
		String email = request.getParameter("email");
		try {
			String em = Validator.checkEmail(email);
			model.setEmail(em);
		}catch(Exception e) {
			error = 3;
			request.setAttribute("errore-registrazione", error);
			dispatcher.forward(request, response);
			return;
		}
		
		String pass = request.getParameter("password");
		String passr=request.getParameter("conferma_password");
		try {
			String p = Validator.checkPassword(pass,passr);
			model.setPass(p);
		}catch(Exception e) {
			if(e.getMessage().equals("Invalid Password"))error = 4;
			else if(e.getMessage().equals("Password don't match")) error = 5;
			request.setAttribute("errore-registrazione", error);
			dispatcher.forward(request, response);
			return;
		}
		
		String matricola = request.getParameter("matricola");
		try {
			int mat = Validator.checkMatricola(matricola);
			model.setMatricola(mat);
		}catch(Exception e) {
			error = 6;
			request.setAttribute("errore-registrazione", error);
			dispatcher.forward(request, response);
			return;
		}
		
		String cellulare = request.getParameter("cellulare");
		try {
			String cell = Validator.checkCellulare(cellulare);
			model.setCellulare(cell);
		}catch(Exception e) {
			error = 7;
			request.setAttribute("errore-registrazione", error);
			dispatcher.forward(request, response);
			return;
		}
		
		model.setTipolaurea(request.getParameter("tipolaurea"));
		model.setDipartimento(request.getParameter("dipartimento"));
		
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

