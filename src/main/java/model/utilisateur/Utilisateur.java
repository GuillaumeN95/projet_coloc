package model.utilisateur;

public abstract class Utilisateur {
	
	protected int id;
	protected String nom;
	protected String prenom;
	protected Civilite civ;
	protected String email;
	protected String tel;
	
	
	
	public Utilisateur() {
		super();
	}



	public Utilisateur(String nom, String prenom, Civilite civ, String email, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.civ = civ;
		this.email = email;
		this.tel = tel;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Civilite getCiv() {
		return civ;
	}



	public void setCiv(Civilite civ) {
		this.civ = civ;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civ=" + civ + ", email=" + email
				+ ", tel=" + tel + "]";
	}



	
	
	
	

}
