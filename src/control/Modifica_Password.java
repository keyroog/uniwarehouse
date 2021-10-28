package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import model.UtenteDao;

/**
 * Servlet implementation class Modifica_Password
 */
@WebServlet("/Modifica_Password")
public class Modifica_Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifica_Password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorPages/accessonegato.jsp");
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String confimrpass = request.getParameter("confirmpass");
		
		try {
			Utente session_user = new Utente();
			HttpSession ssn = request.getSession();
			session_user = (Utente) ssn.getAttribute("user");
			String username = session_user.getEmail();
			System.out.println(username);
			System.out.println(oldpass);
			session_user = checkLogin(username, oldpass);
			if(session_user != null) {
				System.out.println(username);
				UtenteDao model = new UtenteDao();
				model.updatePassword(session_user.getMatricola(), newpass);
				ssn.invalidate();
				dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			}

			/*deve ritornarmi il bean cosi lo metto nella sessione facendo sss.SetAttribute("user", Bean che torna) 
			 * a questo punto in Annuncio_Servlet
			 * quando devo andare a configurare la matricola prendo l'user dalla sessione e faccio il getMatricola
			 */
			 dispatcher.forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("adminRoles", false);
			request.setAttribute("errore-registrazione", 8);
			dispatcher.forward(request, response);
		}
	}
	
	
	private Utente checkLogin(String email, String password) throws Exception {
		UtenteDao dao= new UtenteDao();
		try {
				Utente user = dao.checkLoginDB(email, password, 1);
			if( user != null) {
				return user;
			}
			else
				throw new Exception("Invalid login and password");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
