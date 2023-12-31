package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emprunts.Emprunt;
import emprunts.EmpruntDaoImpl;

/**
 * Servlet implementation class ConsulterEmpruntServlet
 */
@WebServlet("/Servlet/ConsulterEmprunt")
public class ConsulterEmpruntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterEmpruntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/rechercherEmpruntConsulter.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMembre = Integer.parseInt(request.getParameter("membreId"));
        int idOuvrage = Integer.parseInt(request.getParameter("idOuvrage"));
        EmpruntDaoImpl empruntDaoImpl = new EmpruntDaoImpl();
        Emprunt emprunt = null;
		try {
			emprunt = empruntDaoImpl.getEmpruntByid_membreANDidOuvrage(idMembre, idOuvrage);
			System.out.println("bien fait emprunt");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        request.setAttribute("emprunt", emprunt);
		request.getRequestDispatcher("/consulterEmprunt.jsp").forward(request, response);
	}

}
