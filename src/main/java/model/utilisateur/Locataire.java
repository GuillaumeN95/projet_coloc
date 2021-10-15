package model.utilisateur;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import model.logement.Chambre;

@Entity
@DiscriminatorValue("locataire")
public class Locataire extends Utilisateur {
	private boolean recherche;
	private String description;
	private Situation situation;
	private Dossier dossier;
	
	@ManyToOne
	private Chambre chambre;
	
	
	public Locataire() {}

	public Locataire(String nom, String prenom, Civilite civ, String email, String tel, boolean recherche,
			String description, Situation situation, Dossier dossier, Chambre chambre) {
		super(nom, prenom, civ, email, tel);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
		this.dossier = dossier;
		this.chambre = chambre;
	}


	public boolean isRecherche() {
		return recherche;
	}

	public void setRecherche(boolean recherche) {
		this.recherche = recherche;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	@Override
	public String toString() {
		return "Locataire [recherche=" + recherche + ", description=" + description + ", situation=" + situation
				+ ", dossier=" + dossier + ", chambre=" + chambre + "]";
	}

	
	
	

}
