package fr.AirBnB.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/enregistrerpropriete")
public class EnregistrerPropriete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/nouvelenregistrement" ).forward( request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String proprioId =request.getParameter("proprioId");
//		String logementId = request.getParameter("logementId");
//		int telephone = Integer.parseInt(request.getParameter("telephone"));
//		String email = request.getParameter("mail");
		this.getServletContext().getRequestDispatcher( "WEB-INF/index.jsp" ).forward( request, response );
	}

}
