package model.utilisateur;

public class Dossier {
	private int id;
	private Double revenu;
	private Double revenuGarant;
	private Situation situation;
	
	
	public Dossier() {
		super();
	}

	public Dossier(Double revenu, Double revenuGarant, Situation situation) {
		this.revenu = revenu;
		this.revenuGarant = revenuGarant;
		this.situation = situation;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	
	
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", revenu=" + revenu + ", revenuGarant=" + revenuGarant + ", situation="
				+ situation + "]";
	}

	
	
}
