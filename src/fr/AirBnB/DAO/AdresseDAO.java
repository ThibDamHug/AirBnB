package fr.AirBnB.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.AirBnB.Beans.Adresse;

public class AdresseDAO extends Dao {
	
	private Adresse adresse;

	public AdresseDAO(Adresse adresse) {
		super();
		this.adresse = adresse;
	}
	
	public AdresseDAO() {

	}
	
	public void addAdresse () {
		try {
			String sql = "INSERT INTO `adresse` (`numerorue`,`rue`,`ville`,`codepostal`) VALUES ('" + this.adresse.getNumerorue() + "','" + this.adresse.getRue() + "','"+this.adresse.getVille()+"','"+this.adresse.getCodepostal()+"')";
			st.executeUpdate( sql );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int returnLastAdresseId () {
		int id = 0;
		try {
			String sql = " SELECT `id` FROM `adresse` ORDER BY `id` DESC LIMIT 1 ";
			ResultSet resultat = st.executeQuery( sql );
			List <Integer> resultatid = new ArrayList<Integer>();
			while (resultat.next()) {
				resultatid.add(resultat.getInt(1));
				id = resultatid.get(0);
			}
			return id; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
