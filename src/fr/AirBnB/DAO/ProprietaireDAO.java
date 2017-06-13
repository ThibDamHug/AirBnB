package fr.AirBnB.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.AirBnB.Beans.Proprietaire;

public class ProprietaireDAO extends Dao {
	

	public void addProprietaire (Proprietaire proprio) {
		try {
			String sql = "INSERT INTO `proprietaire` (`nom`,`password`,`telephone`,`email`) VALUES ('" + proprio.getNom() + "','" + proprio.getPassword() + "','"+ proprio.getTelephone()+"','"+ proprio.getEmail()+"')";
			st.executeUpdate( sql );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public List<Proprietaire> selectionnerTout() throws Exception {
			String sql = "SELECT * FROM `proprietaire` ";
			ResultSet resultat = st.executeQuery( sql );
			List<Proprietaire> listeProprietaire = new ArrayList<Proprietaire>(); 
			while (resultat.next()) {
				Proprietaire proprio = new Proprietaire();
				proprio.setId(resultat.getInt("id"));
				proprio.setNom(resultat.getString("nom"));
				proprio.setPassword(resultat.getString("password"));
				proprio.setTelephone(resultat.getString("telephone"));
				proprio.setEmail(resultat.getString("email"));
				listeProprietaire.add(proprio);
			}
			return listeProprietaire;
	}
}
