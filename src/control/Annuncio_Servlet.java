package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import model.AnnuncioDAO;
import model.Utente;
import model.Annuncio;

/**
 * Servlet implementation class Annuncio
 */
@WebServlet("/Annuncio_Servlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB


public class Annuncio_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String SAVE_DIR ="/uploadTemp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Annuncio_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		out.write("Error: GET method is used but POST method is required");
		out.close();
	}
	
	
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }		

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AnnuncioDAO dao = new AnnuncioDAO();
		Annuncio model = new Annuncio();
		HttpSession ctx = request.getSession();
		Utente user = (Utente) ctx.getAttribute("user");
		model.setFkannuncio(user.getMatricola());
		model.setDate();
		model.setDescrizione(request.getParameter("descrizione"));
		model.setNomeLibro(request.getParameter("libro"));
		model.setPrice(request.getParameter("prezzo"));
		model.setDipartimento(request.getParameter("dipartimento"));
		model.setNome(user.getNome());
		model.setCognome(user.getCognome());
		
	    String appPath = request.getServletContext().getRealPath("");
	    String savePath = appPath + File.separator + SAVE_DIR;
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			if (fileName != null && !fileName.equals("")) {
				part.write(savePath + File.separator + fileName);
				try {
					dao.doSave(model, savePath + File.separator + fileName);
					ServletContext ct=getServletContext();
					ct.setAttribute("cambio",1);
				} catch (SQLException e) {
					System.out.println("Error:" + e.getMessage());
					}
			}
		}
		
		/*try {
			dao.doSave(model, image);
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}*/

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homepage.jsp");
		dispatcher.forward(request, response);
	}

}