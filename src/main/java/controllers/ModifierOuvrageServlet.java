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
@WebServlet("/Servlet/modifierOuvrage")
public class ModifierOuvrageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  OuvrageDao ouvrageDao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierOuvrageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		ouvrageDao = new OuvrageDao();
        Ouvrage ouvrage = null;
		try {
			ouvrage = ouvrageDao.findByTitle(titre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (ouvrage != null) {
        	request.setAttribute("ouvrage", ouvrage);
            request.getRequestDispatcher("modifierOuvrage.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nbExemplaires = Integer.parseInt(request.getParameter("nbExemplaires"));
		String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");
		String description = request.getParameter("description");
		ouvrageDao = new OuvrageDao();
		        Ouvrage ouvrage = null;
				ouvrage = new Ouvrage(titre,auteur,description,nbExemplaires);
		        try {
					ouvrageDao.update(ouvrage);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("/Dashboard").forward(request, response);
		    }
		}

		
    	
		
		
		
	

