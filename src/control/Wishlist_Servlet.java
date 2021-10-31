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

import model.Annuncio;
import model.AnnuncioDAO;
import model.Wishlist;

/**
 * Servlet implementation class Wishlist_Servlet
 */
@WebServlet("/Wishlist_Servlet")
public class Wishlist_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wishlist_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annuncio x=null;
		HttpSession ssn = request.getSession();
		Wishlist list = (Wishlist)ssn.getAttribute("wishlist");
		if(list==null) {
			list = new Wishlist();
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		AnnuncioDAO model = new AnnuncioDAO();
		try {
			x = model.doRetrieveById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list.addItem(x);
		ssn.setAttribute("Wishlist", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/wishlist.jsp");
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
