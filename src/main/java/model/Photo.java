package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import model.logement.Logement;

@Entity

public class Photo {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private int id;
	private String libelle;
	private String chemin;
	private int ordre;
	
	@ManyToOne
	private Logement logement;
	
	
	
	public Photo() {
	}


	public Photo(String libelle, String chemin, int ordre) {
		this.libelle = libelle;
		this.chemin = chemin;
		this.ordre = ordre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}


	public int getOrdre() {
		return ordre;
	}


	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}


	public Logement getLogement() {
		return logement;
	}


	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	
	
	
}
