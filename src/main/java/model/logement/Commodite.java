package model.logement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Commodite {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private int id;
	private String libelle;
	
	
	public Commodite() {
		super();
	}


	public Commodite(String libelle) {
		super();
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
		return "Commodite [id=" + id + ", libelle=" + libelle + "]";
	}
	
	

	
}
