package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import penalites.Penalite;
import penalites.PenaliteDao;
import penalites.PenaliteDaoImpl;


@WebServlet("/Servlet/ConsulterPenalites")

public class ConsulterPenalitesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PenaliteDao penaliteDao;

    public void init() {
        penaliteDao = new PenaliteDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Penalite> penalites = penaliteDao.getAllPenalites();
        request.setAttribute("penalites", penalites);
        request.getRequestDispatcher("/consulter_Liste_penalites.jsp").forward(request, response);
    }
}
