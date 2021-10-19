package control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				checkLogin(username, password);
				request.getSession().setAttribute("adminRoles", true);
				redirectedPage = "/homepage.jsp";
			} catch (Exception e) {
				request.getSession().setAttribute("adminRoles", false);
				redirectedPage = "/login-form.jsp";
			}
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
	}

	
	private void checkLogin(String email, String password) throws Exception {
		UtenteDao dao= new UtenteDao();
		try {
			if(dao.checkLoginDB(email, password, 1)) {
				//
			}
			else
				throw new Exception("Invalid login and password");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
