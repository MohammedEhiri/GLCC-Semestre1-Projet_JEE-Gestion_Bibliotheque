package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membres.Membre;
import membres.MembreDao;
import membres.MembreDaoImpl;

/**
 * Servlet implementation class SupprimerMembreServlet
 */
@WebServlet("/Servlet/SupprimerMembre")
public class SupprimerMembreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerMembreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private MembreDao membreDao;

    public void init() {
        membreDao = new MembreDaoImpl();
    }
    @Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		request.getRequestDispatcher("/rechercheMembreSupprimer.jsp").forward(request, response);
    	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String email = request.getParameter("email");
   
        try {
        	Membre membre = membreDao.getMembreByEmail(email);
        	membreDao.supprimerMembre(membre.getId());
        	
        	System.out.println("bien supprimé");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

	

}
