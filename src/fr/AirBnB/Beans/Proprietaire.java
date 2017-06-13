package fr.AirBnB.Beans;

public class Proprietaire {
	
	private int id;
	private String nom;
	private String password;
	private String telephone;
	private String email;
	
	
	/* Permet de creer un proprietaire sans attributs, utlise pour les requetes de SELECT */

	public Proprietaire() {
		super();

	}
	
	/* Permet de creer un proprietaire avec tous ses attributs, utlise pour les requetes d'INSERT */
	
	public Proprietaire(String nom, String password, String telephone, String email) {
		super();
		this.nom = nom;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
	}	

	/* Getters et Setters */
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
