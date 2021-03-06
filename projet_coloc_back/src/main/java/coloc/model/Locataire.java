package coloc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("locataire")
public class Locataire extends Utilisateur {
	private boolean recherche;
	private String description;
	@Enumerated(EnumType.STRING)
	private Situation situation;
	
	@Embedded
	private Dossier dossier;
	
	@OneToOne
	private Chambre chambre;
	
	public Locataire() {}

	public Locataire(String nom, String prenom, Civilite civ, String email, String tel, String password, boolean recherche,
			String description, Situation situation, Dossier dossier, Chambre chambre) {
		super(nom, prenom, civ, email, tel, password);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
		this.dossier = dossier;
		this.chambre = chambre;
	}

	public Locataire(String nom, String prenom, Civilite civ, String email, String tel, String password, boolean recherche,
			String description, Situation situation) {
		super(nom, prenom, civ, email, tel, password);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
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

	@Override
	public String toString() {
		return "Locataire [recherche=" + recherche + ", description=" + description + ", situation=" + situation
				+ ", dossier=" + dossier + ", chambre=" + chambre + "]";
	}
}
