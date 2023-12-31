package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import penalites.Penalite;
import penalites.PenaliteDao;
import penalites.PenaliteDaoImpl;


@WebServlet("/Servlet/AjouterPenalite")
public class AjouterPenaliteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjouterPenaliteServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/AjouterUNEpenalite.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idEmprunt = Integer.parseInt(request.getParameter("idEmprunt"));
		double montant = Double.parseDouble(request.getParameter("montant"));
		
        String dateString = request.getParameter("dateDebut");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateDebut = null;
		try {
			dateDebut = dateFormat.parse(dateString);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        String dateString2 = request.getParameter("dateFin");

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateFin = null;
		try {
			dateFin = dateFormat2.parse(dateString2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		Penalite penalite = new Penalite(idEmprunt,montant,dateDebut,dateFin);
		PenaliteDao penaliteDao = new PenaliteDaoImpl();
		penaliteDao.ajouterPenalite(penalite);
		
		response.sendRedirect("/Bibliotheque/dashboard.jsp");
		
		
	}

}
