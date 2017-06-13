package fr.AirBnB.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.AirBnB.Beans.Logement;
import fr.AirBnB.Beans.Proprietaire;
import fr.AirBnB.DAO.LogementDAO;
import fr.AirBnB.DAO.ProprietaireDAO;

@WebServlet("/creationdisponibilite")
public class CreationDisponibilite extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    String visibilite="";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProprietaireDAO proprioDAO = new ProprietaireDAO();
		proprioDAO.seConnecter();
		
		List<Proprietaire> proprioList = null;
		try {
			proprioList = proprioDAO.selectionnerTout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String optionproprio = "";
		for ( Proprietaire proprio : proprioList) {
			optionproprio += "<option value=" + proprio.getId() + " >" + proprio.getNom() +"</option>";
		}
		proprioDAO.seDeconnecter();
		visibilite = "none";
		request.setAttribute("optionproprio", optionproprio);
		request.setAttribute("visibilite", visibilite);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/creationdisponibilite.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
		proprioDAO.seConnecter();
		
		List<Proprietaire> proprioList = null;
		try {
			proprioList = proprioDAO.selectionnerTout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String optionproprio = "";
		for ( Proprietaire proprio : proprioList) {
			optionproprio += "<option value=" + proprio.getId() + " >" + proprio.getNom() +"</option>";
		}
		proprioDAO.seDeconnecter();
		request.setAttribute("optionproprio", optionproprio);
		
		int proprioId =Integer.parseInt(request.getParameter("proprioId"));
		LogementDAO logementDAO = new LogementDAO();		
		logementDAO.seConnecter();
		List<Logement> logementList = new ArrayList<Logement>();
		try {
			logementList = logementDAO.listerTousLesLogements(proprioId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logementDAO .seDeconnecter();
		
		if (logementList.isEmpty()){
			visibilite = "none";
			request.setAttribute("visibilite", visibilite);
			String nologement = "<p> Il n'y a pas de logement pour ce proprietaire. Pensez à lui en creer un avant d'ajouter une disponibilite</p>";
			request.setAttribute("nologement", nologement);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/creationdisponibilite.jsp" ).forward( request, response );
		} else {
			
		String optionjour = "";
			for ( int i=1 ; i < 32; i++ ) {
				optionjour += "<option value=" + i + " >"  + i +  "</option>";
			};
		
		String optionmois = "";
			for ( int i=1 ; i < 13; i++ ) {
				optionmois += "<option value=" + i + " >"  + i +  "</option>";
			};
			
		String optionans = "";
			for ( int i=2017 ; i < 2024; i++ ) {
				optionans += "<option value=" + i + " >"  + i +  "</option>";
			};
		
		String optionlogement = "";
			for ( Logement logement : logementList) {
				optionlogement += "<option value=" + logement.getId() + " >" + logement.getAdresse().getNumerorue() + " - " + logement.getAdresse().getRue() + "";
			};
			
		request.setAttribute("optionjour", optionjour);
		request.setAttribute("optionmois", optionmois);
		request.setAttribute("optionans", optionans);
		request.setAttribute("optionlogement", optionlogement);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/creationdisponibilite.jsp" ).forward( request, response );
		}
	}
}
