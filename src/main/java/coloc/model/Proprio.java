package coloc.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("proprio")
public class Proprio extends Utilisateur {
	
	@OneToMany(mappedBy = "proprietaire" )
	private List<Logement> logements;
	
	public Proprio() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Proprio(String nom, String prenom, Civilite civ, String email, String tel, String password, List<Logement> logements) {
		super(nom, prenom, civ, email, tel, password);
		this.logements = logements;
	}
	
	
	
	

	/*@Override
	public String toString() {
		return "Proprio [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civ=" + civ
				+ ", email=" + email + ", tel=" + tel + "]";
	}*/

	


	
	

}
