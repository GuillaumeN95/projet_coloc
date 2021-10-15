package model;

import model.utilisateur.Utilisateur;

public class Message {
	private int id;
	private Utilisateur emetteur;
	private Utilisateur destinataire;
	private String contenu;
	
	
	public Message() {
		super();
	}


	public Message(Utilisateur emetteur, Utilisateur destinataire, String contenu) {
		super();
		this.id = id;
		this.emetteur = emetteur;
		this.destinataire = destinataire;
		this.contenu = contenu;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Utilisateur getEmetteur() {
		return emetteur;
	}


	public void setEmetteur(Utilisateur emetteur) {
		this.emetteur = emetteur;
	}


	public Utilisateur getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", emetteur=" + emetteur + ", destinataire=" + destinataire + ", contenu="
				+ contenu + "]";
	}
	
	
	

}
