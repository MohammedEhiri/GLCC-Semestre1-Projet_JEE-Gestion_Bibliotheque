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
 * Servlet implementation class RechercherMembreServlet
 */
@WebServlet("/Servlet/ConsulterMembre")
public class ConsulterMembreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MembreDao membreDao;

    public void init() {
        membreDao = new MembreDaoImpl();
    }
    
    @Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/Bibliotheque/rechercherMembreConsulter.jsp");
    	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("emailRecherche");
        try {
            Membre membre = membreDao.getMembreByEmail(email);
            if (membre != null) {
                request.setAttribute("membre", membre);
                response.sendRedirect("/Bibliotheque/ConsulterMembre.jsp");            } 
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Une erreur est survenue lors de la recherche du membre.");
            request.getRequestDispatcher("erreur.jsp").forward(request, response);
        }
    }
}
