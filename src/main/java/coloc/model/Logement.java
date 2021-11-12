package coloc.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Logement {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private int id;
	private String description;
	private int surface;
	private int nChambre;
	private int nChambreOccup;
	private int nSdb;
	private Double loyer;
	
	@OneToMany(mappedBy = "logement")
	private List<Photo> photos;
	
	@OneToMany(mappedBy = "logement")
	private List<Notation> notations;
	
	private LocalDate dateDispo;
	private int dureeMini;
	
	@ManyToOne
	private Proprio proprietaire;
	
	@OneToOne
	private Localisation localisation;
	@Enumerated(EnumType.STRING)
	private TypeLogement typeLogement;
	
	@OneToMany(mappedBy = "logement")
	private List<Chambre> chambres;
	
	@OneToMany
	@JoinTable
	(
		name="Commodite_Logement",
		joinColumns = @JoinColumn(name="idLogement"),
		inverseJoinColumns = @JoinColumn(name="idCommodites")
	)
	private  List<Commodite> commodites;
	
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
	

	public Logement(String description, int surface, int nchambre, int nChambreOccup, int nSdb, Double loyer,
			Localisation localisation,TypeLogement typeLogement) {
		super();
		this.description = description;
		this.surface = surface;
		this.nChambre = nchambre;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.localisation = localisation;
		this.typeLogement = typeLogement;
	}
	
	public Logement(Proprio proprietaire, String description, int surface, int nchambre, int nChambreOccup, int nSdb, Double loyer,
			Localisation localisation,TypeLogement typeLogement, List<Commodite> commodites,List<Regle> regles) {
		super();
		this.proprietaire = proprietaire;
		this.description = description;
		this.surface = surface;
		this.nChambre = nchambre;
		this.nChambreOccup = nChambreOccup;
		this.nSdb = nSdb;
		this.loyer = loyer;
		this.localisation = localisation;
		this.typeLogement = typeLogement;
		this.commodites = commodites;
		this.regles = regles;
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



	public int getnChambre() {
		return nChambre;
	}



	public void setnChambre(int nChambre) {
		this.nChambre = nChambre;
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






	public void setRegles(List<Regle> regles) {
		this.regles = regles;
	}



	public List<Notation> getNotations() {
		return notations;
	}



	public void setNotations(List<Notation> notations) {
		this.notations = notations;
	}



	public Proprio getProprietaire() {
		return proprietaire;
	}



	public void setProprietaire(Proprio proprietaire) {
		this.proprietaire = proprietaire;
	}

	


	public List<Photo> getPhotos() {
		return photos;
	}



	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}



	public List<Regle> getRegles() {
		return regles;
	}



	@Override
	public String toString() {
		return "Logement [id=" + id + ", description=" + description + ", nChambre=" + nChambre + ", nChambreOccup="
				+ nChambreOccup + ", loyer=" + loyer + ", typeLogement="
				+ typeLogement + "]";
	}




	

	
	
	
}
