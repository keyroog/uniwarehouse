package interazioneannunci;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annunci.Annuncio;
import annunci.AnnuncioDAO;

/**
 * Servlet implementation class Modifica_Annuncio
 */
@WebServlet("/Modifica_Annuncio")
public class Modifica_Annuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifica_Annuncio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String titolo=request.getParameter("libro");
		String descrizione=request.getParameter("descrizione");
		String prezzo=request.getParameter("prezzo");
		
		AnnuncioDAO model = new AnnuncioDAO();
		Annuncio bean = new Annuncio();
		
		try {
			bean = model.doRetrieveById(id);
			String app="";
			app=bean.getNomeLibro();
			if(!app.equals(titolo)) {
				model.update(id, titolo, "nomelibro");
			}
			app=bean.getDescrizione();
			if(!app.equals(descrizione)) {
				model.update(id, descrizione, "descrizione");
			}
			app=bean.getPrice();
			if(!app.equals(prezzo)) {
				model.update(id, prezzo, "prezzo");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/impostazioni.jsp");
		dispatcher.forward(request, response);
	}

}
