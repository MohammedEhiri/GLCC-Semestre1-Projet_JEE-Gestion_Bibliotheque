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
 * Servlet implementation class SupprimerOuvrageServlet
 */
@WebServlet("/Servlet/SupprimerOuvrage")
public class SupprimerOuvrageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerOuvrageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/rechercherOuvrageSupprimer.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		OuvrageDao ouvrageDao = new OuvrageDao();
		        Ouvrage ouvrage = null;
				try {
					ouvrage = ouvrageDao.findByTitle(titre);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        if (ouvrage != null) {
		        	try {
						ouvrageDao.delete(titre);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		        } else {
		            response.sendError(HttpServletResponse.SC_NOT_FOUND);
		        }
		    }
	}


