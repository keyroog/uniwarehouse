package control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import model.UtenteDao;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			ServletContext ct = getServletContext();
			ct.setAttribute("cambio", 0);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorPages/accessonegato.jsp");
			String username = request.getParameter("email");
			String password = request.getParameter("password");
			try {
				Utente session_user = new Utente();
				session_user= checkLogin(username, password);
				HttpSession ctx = request.getSession();
				ctx.setAttribute("user", session_user);
				 dispatcher = getServletContext().getRequestDispatcher("/homepage.jsp");
				
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
	
	
	
	
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
