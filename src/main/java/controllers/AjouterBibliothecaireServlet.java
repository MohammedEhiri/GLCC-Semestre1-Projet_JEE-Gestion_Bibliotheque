package controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliothecaire.Bibliothecaire;
import bibliothecaire.BibliothecaireDao;
import bibliothecaire.BibliothecaireDaoImpl;

@WebServlet("/Servlet/ajouterBibliothecaire")
public class AjouterBibliothecaireServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BibliothecaireDao bibliothecaireDao;

    public void init() {
        bibliothecaireDao = new BibliothecaireDaoImpl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Bibliothecaire bibliothecaire = new Bibliothecaire();
        bibliothecaire.setNom(nom);
        bibliothecaire.setPrenom(prenom);
        bibliothecaire.setEmail(email);
        bibliothecaire.setUsername(username);
        bibliothecaire.setPassword(password);
        try {
            bibliothecaireDao.add(bibliothecaire);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/Bibliotheque/ConnexionBibliothecaire").forward(request, response);
    }
}
