package annunci;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				char segno=prezzo.charAt(0);
				if(segno=='-') {
					request.setAttribute("errore-modifica", 1);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorPages/erroreModifica.jsp");
					dispatcher.forward(request, response);
					return;
				}
				Pattern p = Pattern.compile("[0-9]{1,}[,][0-9]{2,}");
				Matcher m = p.matcher(prezzo);
				if(!m.matches()) {
					request.setAttribute("errore-modifica", 2);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorPages/erroreModifica.jsp");
					dispatcher.forward(request, response);
					return;
				}
				
				
				model.update(id, prezzo, "prezzo");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/homepage.jsp");
		dispatcher.forward(request, response);
	}

}
