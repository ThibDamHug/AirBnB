package fr.AirBnB.Beans;

public class Adresse {
	
	private int numerorue;
	private String rue;
	private String ville;
	private int codepostal;
	private int adresseId;
	
	public Adresse(int numerorue, String rue, int codepostal, String ville) {
		super();
		this.numerorue = numerorue;
		this.rue = rue;
		this.ville = ville;
		this.codepostal = codepostal;
	}
	
	public Adresse() {

	}

	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}
	public int getNumerorue() {
		return numerorue;
	}
	public void setNumerorue(int numerorue) {
		this.numerorue = numerorue;
	}

	public int getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(int adresseId) {
		this.adresseId = adresseId;
	}
	
}
