package fr.AirBnB.divers;

public class Validation {	
	
	public static void validernom(String nom) throws Exception {
		if (nom.trim().length() < 3) {
			throw new Exception ("Le nom doit contenir au moins 3 caracteres"); 
		}
	}
	
	public static void validerpasswordenregistrement(String password) throws Exception {
		if (password.trim().length() < 3) {
			throw new Exception ("Le nom de passe doit contenir au moins 3 caracteres");
		}
	}
	
	public static void validertelephone( int telephone) throws Exception {
		System.out.println(telephone);
		String temp = Integer.toString(telephone);
		if (!temp.matches("^0[1-68]([-. ]?[0-9]{2}){4}$") ) {
			throw new Exception ("Le numero doit comporter 10 chiffres");
		}
	}

	public static void validermail(String email) throws Exception {
		if ( !email.matches ("^[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,6})$")) {
			throw new Exception ("Merci de saisir une adresse valide");
		}
	}
	
	public static void validerCodePostale(int codepostale) throws Exception {
		String temp = String.valueOf(codepostale);
		if (!temp.matches("[0-9]{5}")) {
			throw new Exception ("Le code postal doit comporter 5 chiffres"); 
		}
	}
	
	public static void validerRue(String ville) throws Exception {
		if (ville.trim().length() < 1) {
			throw new Exception ("La rue ne doit pas etre vide"); 
		}
	}

	public static void validerVille(String ville) throws Exception {
		if (ville.trim().length() < 1) {
			throw new Exception ("La ville ne doit pas etre vide"); 
		}
	}

	public static void validerDescriptionLogement(String descriptionlogement) throws Exception {
		if (descriptionlogement.trim().length() < 1) { 
			throw new Exception ("Le champ ne doit pas etre vide"); 
		}
	}
}
