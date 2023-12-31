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
 * Servlet implementation class AjouterOuvrageServlet
 */
@WebServlet("/Servlet/ajouterOuvrage")
public class AjouterOuvrageServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OuvrageDao ouvrageDao;

    public void init() {
        ouvrageDao = new OuvrageDao();
    }
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.sendRedirect("/Bibliotheque/AjouterOuvrage.jsp");
    	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String description = request.getParameter("description");
        int nbExemplaires = Integer.parseInt(request.getParameter("nbExemplaires"));

        Ouvrage ouvrage = new Ouvrage(titre, auteur, description, nbExemplaires);
        try {
			ouvrageDao.ajouterOuvrage(ouvrage);
			response.sendRedirect("/Bibliotheque/Servlet/Dashboard");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
