package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Annuncio;
import model.AnnuncioDAO;
import model.Wishlist;

@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		Wishlist<Annuncio> cart = (Wishlist<Annuncio>) request.getSession().getAttribute("carrello");
		if (cart == null) {
			cart = new Wishlist<Annuncio>();
		}
		
		AnnuncioDAO model = new AnnuncioDAO();
		String sort = request.getParameter("sort");

		String action = request.getParameter("action");
		try {
			if (action != null) {
				if (action.equals("addCart")) {
					String id = request.getParameter("id");
					Annuncio bean = model.doRetrieveById(id);
					if (bean != null) {
						cart.addItem(bean);
						request.setAttribute("message", "Product " + bean.getNomeLibro() + " added to cart");
					}
				} else if (action.equals("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.deleteItem(id);
					request.setAttribute("message", "Product deleted");
					}
				}
		} catch (SQLException | NumberFormatException e) {
			request.setAttribute("error", e.getMessage());
		}

		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			request.setAttribute("error", e.getMessage());
		}
		
		request.getSession().setAttribute("carrello", cart);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/wishlist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
