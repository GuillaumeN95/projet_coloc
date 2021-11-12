package coloc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Utilisateur emetteur;
	@OneToOne
	private Utilisateur destinataire;
	private String contenu;
	
	public Message() {
		super();
	}

	public Message(Utilisateur emetteur, Utilisateur destinataire, String contenu) {
		super();
		this.emetteur = emetteur;
		this.destinataire = destinataire;
		this.contenu = contenu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
