package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import penalites.PenaliteDao;
import penalites.PenaliteDaoImpl;

@WebServlet("/Servlet/SupprimerPenalite")
public class SupprimerPenaliteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PenaliteDao penaliteDao;

    public void init() {
        penaliteDao = new PenaliteDaoImpl(); 
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getRequestDispatcher("/rechercherPenaliteSupprimer.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int penaliteId = Integer.parseInt(request.getParameter("id")); 
        penaliteDao.supprimerPenalite(penaliteId); 
        response.sendRedirect("/Bibliotheque/dashboard.jsp"); 
    }
}
