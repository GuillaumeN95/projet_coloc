package coloc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Photo {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Long id;
	private String libelle;
	private String chemin;
	private Integer ordre;
	
	@ManyToOne
	private Logement logement;
	
	public Photo() {
	}

	public Photo(String libelle, String chemin, Integer ordre) {
		this.libelle = libelle;
		this.chemin = chemin;
		this.ordre = ordre;
	}

	public Photo(String libelle, String chemin, Integer ordre, Logement logement) {
		this.libelle = libelle;
		this.chemin = chemin;
		this.ordre = ordre;
		this.logement = logement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}
}
