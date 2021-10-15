package app;

import java.util.List;

import model.*;
import model.utilisateur.*;
import util.Context;

public class TestColoc {
	
	//----------------------------------------------------------------------
	
	/*
	 * Méthode pour revenir au menu
	 */
	
	public void retourMenu() {
		// Retour au menu correspondant à l'utilisateur connecté (Proprio / Locataire)
		int retourMenu = Context.getInstance().saisieInt("Voulez vous : 1 - Afficher la liste des messages reçus | 2 - Revenir au menu : ");
		if(retourMenu==1) {
			afficherListeMessageRecus();
		} else {
			if(Context.getInstance().getUtisateurConnecte() instanceof Locataire) {
				menuLocataire();
			}
			menuProprietaire();
		}
	}
	
	/*
	 * Méthodes messages
	 */
	
	public void afficherListeMessageRecus() {
		// Affiche la liste des messages reçus
		List<Message> messages = Context.getInstance().daoMessage().findAllByIdDestinataire(Context.getInstance().getUtisateurConnecte().getId());
		for(Message m : messages) {
			System.out.println("Message n°" + m.getId() +" de " + m.getEmetteur().getNom() + " " + m.getEmetteur().getPrenom());
		}
		String choix = Context.getInstance().saisieString("Voulez vous lire un message : (O/N)");
		if(choix.toUpperCase().equals("O")) {
			int idMessage = Context.getInstance().saisieInt("Entrez le numéro du message que vous souhaitez lire : ");
			afficherMessage(idMessage);
		} else {
			retourMenu();
		}
	}
	
	public void afficherListeMessageEnvoyes() {
		// Affiche la liste des messages envoyes
		List<Message> messages = Context.getInstance().daoMessage().findAllByIdEmetteur(Context.getInstance().getUtisateurConnecte().getId());
		for(Message m : messages) {
			System.out.println("Message n°" + m.getId() +" à " + m.getDestinataire().getNom() + " " + m.getDestinataire().getPrenom());
		}
	}
	
	public void afficherMessage(int idMessage) {
		// Affiche un message par son id dans la BDD
		Message message = Context.getInstance().daoMessage().findByIdAndByIdDestinataire(idMessage, Context.getInstance().getUtisateurConnecte().getId());
		System.out.println("Message n°" + m.getId() +" de " + m.getEmetteur().getNom() + " " + m.getEmetteur().getPrenom());
		System.out.println(message.getContenu());
		String choix = Context.getInstance().saisieString("Voulez vous supprimer ce message : (O/N)");
		if(choix.toUpperCase().equals("O")) {
			supprimerMessage(message.getId());
		}
		retourMenu();
	}
	
	public void supprimerMessage(int idMessage) {
		// Supprime un message par son id dans la BDD
		Message message = Context.getInstance().daoMessage().findByIdAndByIdDestinataire(idMessage, Context.getInstance().getUtisateurConnecte().getId());
		Context.getInstance().daoMessage().delete(message);
		System.out.println("Message supprimé");
	}
	
	public void envoyerMessage() {
		// Envoie un nouveau message
		String mailDestinataire = Context.getInstance().saisieString("Entrez l'email du destinataire : ");
		Utilisateur destinataire = Context.getInstance().doaUtilisateur().findByEmail(mailDestinataire);
		if(destinataire == null) {
			System.out.println("L'adresse mail saisie ne correspond à aucun utilisateur.");
			envoyerMessage();
		}
		String contenu = Context.getInstance().saisieString("Saissisez votre message : ");
		Message newMessage = new Message(Context.getInstance().getUtisateurConnecte(), destinataire, contenu);
		newMessage = Context.getInstance().daoMessage().save(newMessage);
		System.out.println("Message envoyé");
		retourMenu();
	}
	
	/*
	 *  Main
	 */
	
	public static void main(String[] args) {
	
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		System.out.println("1 - Se connecter");
		System.out.println("2 - Creer un compte");
		System.out.println("3 - STOP");
	
		int choix = Context.getInstance().saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : creerCompte();break;
		case 3 : System.exit(0);
		}
		menuPrincipal();
	}

	
	
	public static void connexion() {
		String login = Context.getInstance().saisieString("Saisir votre login");
		String password = Context.getInstance().saisieString("Saisir votre password");
		
		//A MODIFER
		Utilisateur connexion = Context.getInstance().daoUtilisateur.connect(login,password);
		//
		if(connexion instanceof Locataire) {menuLocataire(); Context.getInstance().setUtisateurConnecte(connexion);}
		else if(connexion instanceof Proprio) {menuProprietaire(); Context.getInstance().setUtisateurConnecte(connexion);}
		else {System.out.println("Identifiants invalides");connexion();}
	}
	
	
	public static void creerCompte() {
		
	}
	
	public static void menuLocataire() {
		System.out.println("1 - Voir/Modifier mon profil");
		System.out.println("2 - Voir les annonces");
		System.out.println("3 - Lire mes messages");
		System.out.println("4 - Envoyer un message");
		System.out.println("5 - Noter un appartement");
		System.out.println("6 - Se deconnecter");
		System.out.println("7 - STOP");
		
		int choix = Context.getInstance().saisieInt("Choisir un menu :");
		switch(choix)
		{
		case 1 : modifierProfil();break;
		case 2 : voirAnnonce();break;
		case 3 : afficherListeMessageRecus();break;
		case 4 : envoyerMessage();break;
		case 5 : noterAppart();break;
		case 6 : System.out.println("Deconnexion...");Context.getInstance().setUtisateurConnecte(null);connexion();break;
		case 7 : System.exit(0);
		}
	}
	
	public static void menuProprietaire() {
		System.out.println("1 - Voir/Modifier mon profil");
		System.out.println("2 - Ajouter un logement");
		System.out.println("3 - Voir/Modifier un logement");
		System.out.println("4 - Voir les dossiers de candidature");
		System.out.println("5 - Modifier les disponibilit�s d'un logement");
		System.out.println("6 - Lire mes messages");
		System.out.println("7 - Ecrire un message");
		System.out.println("8 - Se deconnecter");
		System.out.println("9 - Stop");
		
		int choix = Context.getInstance().saisieInt("Choisir un menu :");
		switch(choix)
		{
		case 1 : modifierProfil();break;
		case 2 : ajoutAppart();break;
		case 3 : modifAppart();break;
		case 4 : validerDossier();break;
		case 5 : rendreDispo();break;
		case 6 : envoyerMessage();break;
		case 7 : afficherListeMessageRecus();break;
		case 8 : System.out.println("Deconnexion...");Context.getInstance().setUtisateurConnecte(null);connexion();break;
		case 9 : System.exit(0);
		}
	}
	
	
	
}
