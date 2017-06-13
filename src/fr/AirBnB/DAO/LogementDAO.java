package fr.AirBnB.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.AirBnB.Beans.Adresse;
import fr.AirBnB.Beans.Logement;
import fr.AirBnB.Beans.Proprietaire;

public class LogementDAO extends Dao {
	
	private Logement logement;
	
	public LogementDAO(Logement logement) {
			this.logement = logement;
	}
	
	public LogementDAO() {

	}

	public void addLogement () {
		try {
			String sql = "INSERT INTO `logement` (`description`,`proprietaire_id`,`adresse_id`) VALUES ('" + this.logement.getDescription() + "','" + this.logement.getProprio_id() + "','" + this.logement.getAdresse_id() + "')";
			st.executeUpdate( sql );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  List<Logement> listerTousLesLogements(int proprioId) throws Exception {
			String sql = "SELECT * "
					+ "FROM `logement` "
					+ "INNER JOIN `proprietaire` "
					+ "ON logement.proprietaire_id = proprietaire.id  "
					+ "INNER JOIN `adresse` "
					+ "ON logement.adresse_id = adresse.id "
					+ "WHERE proprietaire.id ="+ proprioId +"" ;
			ResultSet resultat = st.executeQuery( sql );
			List <Logement> listeLogement = new ArrayList<Logement>(); 
			while (resultat.next()) {
				Logement logement = new Logement();
				Adresse adresse = new Adresse();
				Proprietaire proprio = new Proprietaire();
				proprio.setNom(resultat.getString("proprietaire.nom"));
				logement.setProprio(proprio);
				adresse.setNumerorue(resultat.getInt("adresse.numerorue"));
				adresse.setRue(resultat.getString("adresse.rue"));
				adresse.setCodepostal(resultat.getInt("adresse.codepostal"));
				adresse.setVille(resultat.getString("adresse.ville"));
				logement.setAdresse(adresse);
				listeLogement.add(logement);
			}
			return listeLogement;
	}
}