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
import emprunts.EmpruntDaoImpl;

/**
 * Servlet implementation class ModifierEmpruntServlet
 */
@WebServlet("/Servlet/ModifierEmprunt")
public class ModifierEmpruntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEmpruntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        EmpruntDaoImpl empruntDaoImpl = new EmpruntDaoImpl();
        Emprunt emprunt = null;
		try {
			emprunt = empruntDaoImpl.getEmpruntById(id);
			System.out.println("bien fait emprunt");
			request.setAttribute("emprunt", emprunt);
			response.sendRedirect("/Bibliotheque/modifierEmprunt.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	        
	        


	       
			EmpruntDaoImpl empruntDao = new EmpruntDaoImpl();

	        Emprunt emprunt = new Emprunt(idMembre, idOuvrage, dateEmprunt, dateRetour);

	        try {
	            empruntDao.modifierEmprunt(emprunt);
	            System.out.println("bien fait emprunt");
	    		request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("erreur");
	        }
	}

}
