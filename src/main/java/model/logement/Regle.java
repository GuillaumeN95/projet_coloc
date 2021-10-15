package model.logement;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity

public class Regle {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private int id;
	private String libelle;
	
	@ManyToMany(mappedBy = "regles")
	private List<Logement> logements;
	

	
	public Regle() {
		super();
	}


	public Regle(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
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


	@Override
	public String toString() {
		return "Regle [id=" + id + ", libelle=" + libelle + "]";
	}
	
	

}
