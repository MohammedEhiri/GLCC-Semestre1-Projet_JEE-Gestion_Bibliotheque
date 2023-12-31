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

@WebServlet("/Servlet/ajouterMembre")
public class AjouterMembreServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MembreDao membreDao;

    public void init() throws ServletException {
        super.init();
        membreDao = new MembreDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String password = request.getParameter("password");

        password = PasswordUtil.hashPassword(password);

        Membre membre = new Membre(nom, prenom, email, type, password);
        try {
        	
            membreDao.ajouterMembre(membre);
            response.sendRedirect("/Bibliotheque/Servlet/Dashboard");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
     }
}
