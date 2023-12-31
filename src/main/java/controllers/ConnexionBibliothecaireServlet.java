package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bibliothecaire.Bibliothecaire;
import bibliothecaire.BibliothecaireDao;
import bibliothecaire.BibliothecaireDaoImpl;
import ouvrages.OuvrageDao;



@WebServlet("/ConnexionBibliothecaire")
public class ConnexionBibliothecaireServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BibliothecaireDao bibliothecaireDao;

    public void init() throws ServletException {
        bibliothecaireDao = new BibliothecaireDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/connexion.jsp").forward(request, response);
    }

    
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Bibliothecaire bibliothecaire;
        
        
        try {
            bibliothecaire = bibliothecaireDao.getByUsernameAndPassword(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("bibliothecaire", bibliothecaire);
            if (bibliothecaire != null) {
            	
            	OuvrageDao ouvrageDao = new OuvrageDao();
                response.sendRedirect("/Bibliotheque/Servlet/Dashboard");

                return;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("error", "Nom d'utilisateur ou mot de passe invalide.");
        request.getRequestDispatcher("/Bibliotheque/erreur.jsp").forward(request, response);
       

    }

}
