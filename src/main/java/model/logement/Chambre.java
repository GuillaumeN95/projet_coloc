package model.logement;

import java.time.LocalDate;
import java.util.List;

public class Chambre {
	
	private int id;
	private Logement logement;
	private int surface;
	private Double loyer;
	private Double charges;
	private Double caution;
	private int dureeMini;
	private LocalDate dateDispo;
	private List<Commodite> commodites;
	private List<Regle> regles;
	
	
	
	public Chambre() {
	}



	public Chambre(Logement logement, int surface, Double loyer, Double charges, Double caution, int dureeMini,
			LocalDate dateDispo, List<Commodite> commodites, List<Regle> regles) {
		this.logement = logement;
		this.surface = surface;
		this.loyer = loyer;
		this.charges = charges;
		this.caution = caution;
		this.dureeMini = dureeMini;
		this.dateDispo = dateDispo;
		this.commodites = commodites;
		this.regles = regles;
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



	public List<Regle> getRegles() {
		return regles;
	}



	public void setRegles(List<Regle> regles) {
		this.regles = regles;
	}

	
	

}
