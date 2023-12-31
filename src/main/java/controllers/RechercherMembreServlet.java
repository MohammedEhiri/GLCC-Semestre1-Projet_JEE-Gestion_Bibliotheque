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

@WebServlet("/Servlet/RechercherMembre")
public class RechercherMembreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MembreDao membreDao;

    public void init() {
        membreDao = new MembreDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("rechercherMembreModifier.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        try {
            Membre membre = membreDao.getMembreByEmail(email);
            if (membre != null) {
                request.setAttribute("membre", membre);
                request.getRequestDispatcher("modifierMembre.jsp").forward(request, response);
            } 
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
