package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emprunts.Emprunt;
import emprunts.EmpruntDao;
import emprunts.EmpruntDaoImpl;
import membres.MembreDaoImpl;
import ouvrages.OuvrageDao;

@WebServlet("/Servlet/AjouterEmprunt")
public class AjouterEmpruntServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpruntDao empruntDao;
    public void init() {
        empruntDao = new EmpruntDaoImpl();
        new OuvrageDao();
        new MembreDaoImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/AjouterEmprunt.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        int idMembre = Integer.parseInt(request.getParameter("membreId"));
        int idOuvrage = Integer.parseInt(request.getParameter("idOuvrage"));
        
        
		
        String dateString = request.getParameter("dateEmprunt");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateEmprunt = null;
		try {
			dateEmprunt = dateFormat.parse(dateString);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        String dateString2 = request.getParameter("dateRetour");

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateRetour = null;
		try {
			dateRetour = dateFormat2.parse(dateString2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        


       

        Emprunt emprunt = new Emprunt(idMembre, idOuvrage, dateEmprunt, dateRetour);

        try {
            empruntDao.ajouterEmprunt(emprunt);
            System.out.println("bien fait emprunt");
    		request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur");
        }
    }

}
