package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ouvrages.Ouvrage;
import ouvrages.OuvrageDao;

/**
 * Servlet implementation class consulterOuvrageServlet
 */
@WebServlet("/Servlet/consulterOuvrage")
public class consulterOuvrageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  OuvrageDao ouvrageDao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consulterOuvrageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/Bibliotheque/rechercherOuvrage.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		ouvrageDao = new OuvrageDao();
		        Ouvrage ouvrage = null;
				try {
					ouvrage = ouvrageDao.findByTitle(titre);
					if (ouvrage != null) {
			            request.setAttribute("ouvrage", ouvrage);
			            request.getRequestDispatcher("/consulterOuvrage.jsp").forward(request, response);
			            System.out.println("bien fait");
			        } else {
			            response.sendError(HttpServletResponse.SC_NOT_FOUND);
			            System.out.println("n rechercher ouvrage");
			        }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ya une erreur");
				}
		        
		    }
		}

		
    	
		
		
		
	

