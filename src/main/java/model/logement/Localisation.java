package model.logement;

public class Localisation {
	private int id; 
	private String departement;
	private String ville;
	private String codePostal;
	private String voie;
	private int num;

	
	public Localisation() {
		super();
	}

	public Localisation(String departement, String ville, String codePostal, String voie, int num) {
		super();
		this.departement = departement;
		this.ville = ville;
		this.codePostal = codePostal;
		this.voie = voie;
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Localisation [id=" + id + ", departement=" + departement + ", ville=" + ville + ", codePostal="
				+ codePostal + ", voie=" + voie + ", num=" + num + "]";
	}
	
	
	
	

}