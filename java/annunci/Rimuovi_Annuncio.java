package annunci;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interazione_annunci.Wishlist;

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
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/impostazioni.jsp");
		Wishlist<Annuncio> cart = (Wishlist<Annuncio>)request.getSession().getAttribute("carrello");
		AnnuncioDAO model = new AnnuncioDAO();
		int id = Integer.parseInt(request.getParameter("annuncio"));
		ServletContext ctx = getServletContext();
	 	Collection<Annuncio> products = (Collection<Annuncio>) ctx.getAttribute("catalogo");
		for(Annuncio p: products) {
			if(p.getId()==id) {
				products.remove(p);
				break;
				
			}
		}

		try {
			model.doDelete(id);
			if(cart!=null) {
				ctx.setAttribute("rimosso", "1");
				ctx.setAttribute("idrimosso",id);
			}
		} catch (SQLException e) {
			e.printStackTrace(); //pagina qualcosa è andato storto
		}
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
