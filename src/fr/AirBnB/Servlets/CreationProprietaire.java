package fr.AirBnB.Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.AirBnB.Beans.Proprietaire;
import fr.AirBnB.DAO.ProprietaireDAO;
import fr.AirBnB.divers.Validation;

@WebServlet("/creationproprietaire")

public class CreationProprietaire extends HttpServlet {
	private static final long serialVersionUID = 1L;	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher( "/WEB-INF/creationproprietaire.jsp" ).forward( request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Recuperation des champs du formulaire*/
		
		String nom =request.getParameter("nom");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("mail");
		
		/*debut*/
		
		Map <String,String> erreurs = new HashMap<String, String>();
		
		try {
			Validation.validernom(nom);
		} catch (Exception e) {
			erreurs.put("nom", e.getMessage());
		}
		
		try {
			Validation.validerpasswordenregistrement(password);
		} catch (Exception e) {
			erreurs.put("password", e.getMessage());
		}
		
		try {	
			Validation.validermail(email);
		} catch (Exception e) {
			erreurs.put("email", e.getMessage());
		}
		
		request.setAttribute("erreurs", erreurs);
		
		String resultat;

		if (!erreurs.isEmpty()) {
			resultat = "Echec de l'inscription";
			request.setAttribute("resultat", resultat);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/creationproprietaire.jsp" ).forward( request, response );
		} else {
			
			Proprietaire proprio = new Proprietaire(nom , password, telephone ,email);
			ProprietaireDAO proprioDAO = new ProprietaireDAO();
			proprioDAO.seConnecter();
			proprioDAO.addProprietaire(proprio);
			proprioDAO.seDeconnecter();
			String creerProprietaire ="<a href='http://localhost:8080/AirBnB/creationproprietaire'>Creer un autre proprietaire?</a>";
			String creerLogement ="<a href='http://localhost:8080/AirBnB/creationlogement'>creer un nouveau logement ?";
			resultat = "Votre proprietaire a bien été créé.";
			request.setAttribute("resultat", resultat);
			request.setAttribute("creerproprietaire", creerProprietaire);
			request.setAttribute("creerLogement", creerLogement);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/nouvelenregistrement.jsp" ).forward( request, response );
		}	
	}
}
