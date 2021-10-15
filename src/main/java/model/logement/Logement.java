package model.logement;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import model.utilisateur.Locataire;
import model.utilisateur.Proprio;

@Entity

public class Logement {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private int id;
	private String description;
	private int surface;
	private int nChambree;
	private int nChambreOccup;
	private int nSdb;
	private Double loyer;
	private int note;
	private LocalDate dateDispo;
	private int dureeMini;
	
	@ManyToOne
	private Proprio proprietaire;
	
	@OneToOne
	private Localisation localisation;
	
	private TypeLogement typeLogement;
	
	@OneToMany(mappedBy = "logement")
	private List<Chambre> chambres;
	
	@ManyToMany
	@JoinTable
	(
		name="Commodite_Logement",
		joinColumns = @JoinColumn(name="idLogement"),
		inverseJoinColumns = @JoinColumn(name="idCommodites")
	)
	private List<Commodite> commodites;
	
	@ManyToMany
	@JoinTable
	(
		name="Regle_Logement",
		joinColumns = @JoinColumn(name="idLogement"),
		inverseJoinColumns = @JoinColumn(name="idRegle")
	)
	private List<Regle> regles;

	
	
	
	public Logement() {
		super();
	}
	


	public Logement(String description, int surface, int nChambree, int nChambreOccup, int nSdb, Double loyer,
			Localisation localisation) {
		super();
		this.description = description;
		this.surface = surface;
		this.nChambree = nChambree;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.localisation = localisation;
	}



	public Logement(int id, String description, int surface, int nChambree, int nChambreOccup, int nSdb, Double loyer,
			int note, LocalDate dateDispo, int dureeMini, Localisation localisation, TypeLogement typeLogement,
			List<Chambre> chambres, List<Commodite> commodites) {
		super();
		this.id = id;
		this.description = description;
		this.surface = surface;
		this.nChambree = nChambree;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.note = note;
		this.dateDispo = dateDispo;
		this.dureeMini = dureeMini;
		this.localisation = localisation;
		this.typeLogement = typeLogement;
		this.chambres = chambres;
		this.commodites = commodites;
	}









	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getSurface() {
		return surface;
	}



	public void setSurface(int surface) {
		this.surface = surface;
	}



	public int getnChambree() {
		return nChambree;
	}



	public void setnChambree(int nChambree) {
		this.nChambree = nChambree;
	}



	public int getnChambreOccup() {
		return nChambreOccup;
	}



	public void setnChambreOccup(int nChambreOccup) {
		this.nChambreOccup = nChambreOccup;
	}



	public int getnSdb() {
		return nSdb;
	}



	public void setnSdb(int nSdb) {
		this.nSdb = nSdb;
	}



	public Double getLoyer() {
		return loyer;
	}



	public void setLoyer(Double loyer) {
		this.loyer = loyer;
	}



	public int getNote() {
		return note;
	}



	public void setNote(int note) {
		this.note = note;
	}



	public LocalDate getDateDispo() {
		return dateDispo;
	}



	public void setDateDispo(LocalDate dateDispo) {
		this.dateDispo = dateDispo;
	}



	public int getDureeMini() {
		return dureeMini;
	}



	public void setDureeMini(int dureeMini) {
		this.dureeMini = dureeMini;
	}



	public Localisation getLocalisation() {
		return localisation;
	}



	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}



	public TypeLogement getTypeLogement() {
		return typeLogement;
	}



	public void setTypeLogement(TypeLogement typeLogement) {
		this.typeLogement = typeLogement;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	


	public List<Chambre> getChambres() {
		return chambres;
	}





	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	




	public List<Commodite> getCommodites() {
		return commodites;
	}



	public void setCommodites(List<Commodite> commodites) {
		this.commodites = commodites;
	}




	@Override
	public String toString() {
		return "Logement [id=" + id + ", description=" + description + ", surface=" + surface + ", nChambree="
				+ nChambree + ", nChambreOccup=" + nChambreOccup + ", nSdb=" + nSdb + ", loyer=" + loyer + ", note="
				+ note + ", dateDispo=" + dateDispo + ", dureeMini=" + dureeMini + ", localisation=" + localisation
				+ ", typeLogement=" + typeLogement + "]";
	}



	

	
	
	
}
