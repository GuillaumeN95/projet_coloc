package model.utilisateur;

public class Locataire extends Utilisateur {
	private boolean recherche;
	private String description;
	private Situation situation;
	private Dossier dossier;
	
	
	public Locataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Locataire(String nom, String prenom, Civilite civ, String email, String tel, boolean recherche,
			String description, Situation situation, Dossier dossier) {
		super(nom, prenom, civ, email, tel);
		this.recherche = recherche;
		this.description = description;
		this.situation = situation;
		this.dossier = dossier;
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
		return "Locataire [recherche=" + recherche + ", description=" + description + ", nom=" + nom + ", prenom="
				+ prenom + ", civ=" + civ + ", email=" + email + ", tel=" + tel + "]";
	}

	
	

}
