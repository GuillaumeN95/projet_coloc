package model.utilisateur;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import model.logement.Logement;

@Entity
@DiscriminatorValue("proprio")
public class Proprio extends Utilisateur {

	@OneToMany(mappedBy = "proprio")
	private List<Logement> biens;
	
	public Proprio() {}

	
	public Proprio(String nom, String prenom, Civilite civ, String email, String tel, List<Logement> biens) {
		super(nom, prenom, civ, email, tel);
		this.biens = biens;
	}


	public List<Logement> getBiens() {
		return biens;
	}

	public void setBiens(List<Logement> biens) {
		this.biens = biens;
	}


	@Override
	public String toString() {
		return "Proprio [biens=" + biens + "]";
	}
	
	
	
	

}
