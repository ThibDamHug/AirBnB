package fr.AirBnB.Beans;

public class Logement {
	
	/* Proprietes */
	
	private int id;
	private int proprio_id;
	private String description;
	private int adresse_id;

	private Proprietaire proprio;
	private Adresse adresse;
	
	public Logement(String description, int proprio_id) {
		super();
		this.proprio_id = proprio_id;
		this.description = description;
	}
	
	public Logement() {
		super();

	}
	
	public Proprietaire getProprio() {
		return proprio;
	}
	
	public void setProprio(Proprietaire proprio) {
		this.proprio = proprio;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/* Getters et Setters */
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProprio_id() {
		return proprio_id;
	}

	public void setProprio_id(int proprio_id) {
		this.proprio_id = proprio_id;
	}

	public int getAdresse_id() {
		return adresse_id;
	}

	public void setAdresse_id(int adresse_id) {
		this.adresse_id = adresse_id;
	}
		
}
