package control;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.UtenteDao;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			String username = request.getParameter("email");
			String password = request.getParameter("password");
			
			String redirectedPage;
			try {
				Utente session_user;
				session_user= checkLogin(username, password);
				ServletContext ctx = request.getServletContext();
				ctx.setAttribute("user", session_user);

				
				/*deve ritornarmi il bean cosi lo metto nella sessione facendo sss.SetAttribute("user", Bean che torna) 
				 * a questo punto in Annuncio_Servlet
				 * quando devo andare a configurare la matricola prendo l'user dalla sessione e faccio il getMatricola
				 */
				redirectedPage = "/homepage.jsp";
			} catch (Exception e) {
				request.getSession().setAttribute("adminRoles", false);
				redirectedPage = "/login-form.jsp";
			}
			response.sendRedirect(request.getContextPath() + redirectedPage);
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
