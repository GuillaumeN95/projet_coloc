package coloc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Dossier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private Integer version;
	private Double revenu;
	private Double revenuGarant;
	private Situation situationGarant;
	
	@OneToOne(mappedBy = "dossier" )
	private Locataire locataire;
	
	@OneToMany
	private List<Chambre> chambre;
	
	public Dossier() {
		super();
	}

	public Dossier(Double revenu, Double revenuGarant, Situation situationGarant) {
		this.revenu = revenu;
		this.revenuGarant = revenuGarant;
		this.situationGarant = situationGarant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRevenu() {
		return revenu;
	}

	public void setRevenu(Double revenu) {
		this.revenu = revenu;
	}

	public Double getRevenuGarant() {
		return revenuGarant;
	}

	public void setRevenuGarant(Double revenuGarant) {
		this.revenuGarant = revenuGarant;
	}

	public Situation getSituation() {
		return situationGarant;
	}

	public void setSituation(Situation situationGarant) {
		this.situationGarant = situationGarant;
	}
	
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", revenu=" + revenu + ", revenuGarant=" + revenuGarant + ", situation="
				+ situationGarant + "]";
	}
}
