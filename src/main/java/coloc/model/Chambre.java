package coloc.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Chambre {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private int id;
	
	@ManyToOne
	private Logement logement;
	
	@OneToOne(mappedBy = "chambre" )
	private Locataire locataire;
	
	
	private int surface;
	private Double loyer;
	private Double charges;
	private Double caution;
	private int dureeMini;
	private LocalDate dateDispo;
	
	@ManyToMany
	@JoinTable
	(
		name="Commodites_Chambre",
		joinColumns = @JoinColumn(name="idLogement"),
		inverseJoinColumns = @JoinColumn(name="idCommodite")
	)
	private List<Commodite> commodites;
	
	
	public Chambre() {
	}


	public Chambre(Logement logement, int surface, Double loyer, Double charges, Double caution, int dureeMini,
			LocalDate dateDispo) {
		this.logement = logement;
		this.surface = surface;
		this.loyer = loyer;
		this.charges = charges;
		this.caution = caution;
		this.dureeMini = dureeMini;
		this.dateDispo = dateDispo;
	}
	
	public Chambre(Logement logement, int surface, Double loyer, Double charges, Double caution, int dureeMini,
			LocalDate dateDispo, List<Commodite> commodites) {
		this.logement = logement;
		this.surface = surface;
		this.loyer = loyer;
		this.charges = charges;
		this.caution = caution;
		this.dureeMini = dureeMini;
		this.dateDispo = dateDispo;
		this.commodites = commodites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public int getSurface() {
		return surface;
	}
	
	public void setSurface(int surface) {
		this.surface = surface;
	}
	
	public Double getLoyer() {
		return loyer;
	}
	
	public void setLoyer(Double loyer) {
		this.loyer = loyer;
	}
	
	public Double getCharges() {
		return charges;
	}
	
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	
	public Double getCaution() {
		return caution;
	}
	
	public void setCaution(Double caution) {
		this.caution = caution;
	}
	
	public int getDureeMini() {
		return dureeMini;
	}
	
	public void setDureeMini(int dureeMini) {
		this.dureeMini = dureeMini;
	}
	
	public LocalDate getDateDispo() {
		return dateDispo;
	}
	
	public void setDateDispo(LocalDate dateDispo) {
		this.dateDispo = dateDispo;
	}

	public List<Commodite> getCommodites() {
		return commodites;
	}

	public void setCommodites(List<Commodite> commodites) {
		this.commodites = commodites;
	}

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

}
