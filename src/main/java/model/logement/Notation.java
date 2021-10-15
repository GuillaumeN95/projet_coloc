package model.logement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import model.utilisateur.Locataire;

@Entity

public class Notation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Logement logement;

	@OneToOne
	private Locataire locataire;
	
	private double note;
	
	@Column(columnDefinition = "VARCHAR(75)")
	private String commentaire;
	
	
	
	public Notation() {
		super();
	}
	

	public Notation(Logement logement, Locataire locataire, double note, String commentaire) {
		super();
		this.logement = logement;
		this.locataire = locataire;
		this.note = note;
		this.commentaire = commentaire;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Notation [id=" + id + ", note=" + note + ", commentaire=" + commentaire + "]";
	}
	
	
	

}
