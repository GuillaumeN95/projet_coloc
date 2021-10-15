package model.utilisateur;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import model.logement.Logement;

@Entity
@DiscriminatorValue("proprio")
public class Proprio extends Utilisateur {

	
	public Proprio() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Proprio(String nom, String prenom, Civilite civ, String email, String tel, List<Logement> biens) {
		super(nom, prenom, civ, email, tel);
		this.biens = biens;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Proprio [logements=" + logements + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civ=" + civ
				+ ", email=" + email + ", tel=" + tel + "]";
	}

	


	
	

}
