package model.logement;

import java.time.LocalDate;

public class Logement {
	
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
	private Localisation localisation;
	private TypeLogement typeLogement;

	
	
	
	public Logement() {
		super();
	}



	public Logement(String description, int surface, int nChambree, int nChambreOccup, int nSdb, Double loyer, int note,
			LocalDate dateDispo, int dureeMini, Localisation localisation, TypeLogement typeLogement) {
		super();
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



	@Override
	public String toString() {
		return "Logement [id=" + id + ", description=" + description + ", surface=" + surface + ", nChambree="
				+ nChambree + ", nChambreOccup=" + nChambreOccup + ", nSdb=" + nSdb + ", loyer=" + loyer + ", note="
				+ note + ", dateDispo=" + dateDispo + ", dureeMini=" + dureeMini + ", localisation=" + localisation
				+ ", typeLogement=" + typeLogement + "]";
	}



	

	
	
	
}
