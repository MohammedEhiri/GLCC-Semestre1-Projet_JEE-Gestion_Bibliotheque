package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ouvrages.OuvrageDao;

/**
 * Servlet implementation class ConsulterNouveaute
 */
@WebServlet("/Servlet/ConsulterNouveaute")
public class ConsulterNouveauteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterNouveauteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OuvrageDao ouvrageDao = new OuvrageDao();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("ouvragesNouveaute", ouvrageDao.findAllNouveaute());
			response.sendRedirect("/Bibliotheque/ConsulterNouveaute.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	

}
