package fr.AirBnB.Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.AirBnB.Beans.Adresse;
import fr.AirBnB.Beans.Logement;
import fr.AirBnB.Beans.Proprietaire;
import fr.AirBnB.DAO.AdresseDAO;
import fr.AirBnB.DAO.LogementDAO;
import fr.AirBnB.DAO.ProprietaireDAO;
import fr.AirBnB.divers.Validation;



@WebServlet("/creationlogement")
public class CreationLogement extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
		proprioDAO.seConnecter();
		
		List<Proprietaire> proprioList = null;
		try {
			proprioList = proprioDAO.selectionnerTout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		proprioDAO.seDeconnecter();
		request.setAttribute("proprioList", proprioList);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/creationlogement.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Recuperation des champs du formulaire*/
		
		int proprioId =Integer.parseInt(request.getParameter("proprioId"));
		int numerorue = Integer.parseInt(request.getParameter("numerorue"));
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		int codepostal = Integer.parseInt(request.getParameter("codepostal"));
		String descriptionlogement = request.getParameter("descriptionlogement");
		
		/*debut*/
		
		Map <String,String> erreurs = new HashMap<String, String>();
		
		
		try {
			Validation.validerRue(rue);
		} catch (Exception e) {
			erreurs.put("rue", e.getMessage());
		}
		
		try {
			Validation.validerVille(ville);
		} catch (Exception e) {
			erreurs.put("ville", e.getMessage());
		}
		
		try {
			Validation.validerCodePostale(codepostal);
		} catch (Exception e) {
			erreurs.put("codepostal", e.getMessage());
		}
		
		try {
			Validation.validerDescriptionLogement(descriptionlogement);
		} catch (Exception e) {
			erreurs.put("descriptionlogement", e.getMessage());
		}		
	
		request.setAttribute("erreurs", erreurs);


		if (!erreurs.isEmpty()) {
			String resultatlogement = "Echec de la creation du logement";
			request.setAttribute("resultat", resultatlogement);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/creationlogement.jsp" ).forward( request, response );
		} else {

			//Enregistrement de l'adresse
			Adresse adresse = new Adresse(numerorue,rue,codepostal,ville);
			AdresseDAO adresseDAO = new AdresseDAO(adresse);
			adresseDAO.seConnecter();
			adresseDAO.addAdresse();
			adresseDAO.seDeconnecter();
			adresseDAO.seConnecter();
			int adresseId = adresseDAO.returnLastAdresseId();
			adresseDAO.seDeconnecter();

			//Enregistrement du logement
			Logement logement = new Logement (descriptionlogement,proprioId);
			LogementDAO logementDAO =new LogementDAO(logement);
			logementDAO.seConnecter();
			logement.setAdresse_id(adresseId);
			logementDAO.addLogement();
			logementDAO.seDeconnecter();

			String resultat = "Votre logement a bien été enregistré";
			String resultatadresse ="Votre adresse a bien été enregistré";
			String creerLogement ="<a href='http://localhost:8080/AirBnB/creationlogement'>creer un autre logement ?";
			String creerDisponibilite ="<a href='http://localhost:8080/AirBnB/creationdisponibilite'>Ouvrir une période de disponibilité pour un logement ?";
			request.setAttribute("resultatadresse", resultatadresse);
			request.setAttribute("resultat", resultat);
			request.setAttribute("creerLogement", creerLogement);
			request.setAttribute("creerDisponibilite", creerDisponibilite);
			this.getServletContext().getRequestDispatcher( "/nouvelenregistrement" ).forward( request, response );
		}	
	}
}
