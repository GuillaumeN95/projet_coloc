package model.utilisateur;

import java.util.List;

import model.logement.Logement;

public class Proprio extends Utilisateur {
	
	private List<Logement> logements;
	
	public Proprio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proprio(String nom, String prenom, Civilite civ, String email, String tel) {
		super(nom, prenom, civ, email, tel);
		// TODO Auto-generated constructor stub
	}

	public Proprio(String nom, String prenom, Civilite civ, String email, String tel, List<Logement> logements) {
		super(nom, prenom, civ, email, tel);
		this.logements = logements;
	}

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}
	
	

	@Override
	public String toString() {
		return "Proprio [logements=" + logements + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civ=" + civ
				+ ", email=" + email + ", tel=" + tel + "]";
	}

	


	
	

}
