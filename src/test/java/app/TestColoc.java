package app;

import java.util.List;
import java.util.Scanner;

import model.*;
import model.logement.*;
import model.utilisateur.*;
import util.Context;

public class TestColoc {
	
	public static String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}
	
	//----------------------------------------------------------------------
	
	/*
	 * Méthode pour revenir au menu
	 */
	
	public static void retourMenu() {
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
	
	public static void afficherListeMessageRecus() {
		// Affiche la liste des messages reçus
		List<Message> messages = Context.getInstance().getDaoMessage().findAllByIdDestinataire(Context.getInstance().getUtisateurConnecte().getId());
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
	
	public static void afficherListeMessageEnvoyes() {
		// Affiche la liste des messages envoyes
		List<Message> messages = Context.getInstance().getDaoMessage().findAllByIdEmetteur(Context.getInstance().getUtisateurConnecte().getId());
		for(Message m : messages) {
			System.out.println("Message n°" + m.getId() +" à " + m.getDestinataire().getNom() + " " + m.getDestinataire().getPrenom());
		}
	}
	
	public static void afficherMessage(int idMessage) {
		// Affiche un message par son id dans la BDD
		Message message = Context.getInstance().getDaoMessage().findByIdAndByIdDestinataire(idMessage, Context.getInstance().getUtisateurConnecte().getId());
		System.out.println("Message n°" + message.getId() +" de " + message.getEmetteur().getNom() + " " + message.getEmetteur().getPrenom());
		System.out.println(message.getContenu());
		String choix = Context.getInstance().saisieString("Voulez vous supprimer ce message : (O/N)");
		if(choix.toUpperCase().equals("O")) {
			supprimerMessage(message.getId());
		}
		retourMenu();
	}
	
	public static void supprimerMessage(int idMessage) {
		// Supprime un message par son id dans la BDD
		Message message = Context.getInstance().getDaoMessage().findByIdAndByIdDestinataire(idMessage, Context.getInstance().getUtisateurConnecte().getId());
		Context.getInstance().getDaoMessage().delete(message);
		System.out.println("Message supprimé");
	}
	
	public static void envoyerMessage() {
		// Envoie un nouveau message
		String mailDestinataire = Context.getInstance().saisieString("Entrez l'email du destinataire : ");
		Utilisateur destinataire = Context.getInstance().getDaoUtilisateur().findByEmail(mailDestinataire);
		if(destinataire == null) {
			System.out.println("L'adresse mail saisie ne correspond à aucun utilisateur.");
			envoyerMessage();
		}
		String contenu = Context.getInstance().saisieString("Saissisez votre message : ");
		Message newMessage = new Message(Context.getInstance().getUtisateurConnecte(), destinataire, contenu);
		newMessage = Context.getInstance().getDaoMessage().save(newMessage);
		System.out.println("Message envoyé");
		retourMenu();
	}
	
	public static void modifierProfil() {
		
		Utilisateur connected = Context.getInstance().getUtisateurConnecte();
		System.out.println("1 - Le nom");
		System.out.println("2 - Le prenom");
		System.out.println("3 - La civilite");
		System.out.println("4 - L'adresse mail");
		System.out.println("5 - Le numero de telephone");
	
		int choix = Context.getInstance().saisieInt("Que souhaitez-vous modifier ?");
		
		String modif = null;
		int modifInt=0;
		
	//	if(choix==6) { modifInt=saisieInt("saisir modif");}
	//	else{
			modif = saisieString("Saisir la modif");
	//	}
		
		switch(choix) 
		{
		case 1 : connected.setNom(modif);break;
		case 2 : connected.setPrenom(modif);break;
		case 3 : connected.setCiv(Civilite.valueOf(modif));break;
		case 4 : connected.setEmail(modif);break;
		case 5 : connected.setTel(modif);break;
		
		}
		
		Context.getInstance().getDaoUtilisateur().save(connected);
		
	}
	
	
	
	/*
	 *  Main
	 */
	
	public static void main(String[] args) {
//	
//		menuPrincipal();
//	}
//	
//	public static void menuPrincipal() {
//		System.out.println("1 - Se connecter");
//		System.out.println("2 - Creer un compte");
//		System.out.println("3 - STOP");
//	
//		int choix = Context.getInstance().saisieInt("Choisir un menu :");
//		switch(choix) 
//		{
//		case 1 : connexion();break;
//		case 2 : creerCompte();break;
//		case 3 : System.exit(0);
//		}
//		menuPrincipal();
//	}
//
//	
//	
//	public static void connexion() {
//		String login = Context.getInstance().saisieString("Saisir votre login");
//		String password = Context.getInstance().saisieString("Saisir votre password");
//		
//		//A MODIFER
//		Utilisateur connexion = Context.getInstance().getDaoUtilisateur().connect(login,password);
//		//
//		if(connexion instanceof Locataire) {menuLocataire(); Context.getInstance().setUtisateurConnecte(connexion);}
//		else if(connexion instanceof Proprio) {menuProprietaire(); Context.getInstance().setUtisateurConnecte(connexion);}
//		else {System.out.println("Identifiants invalides");connexion();}
//	}
//	
//	
//	public static void creerCompte() {
//		
//	}
//	
//	public static void menuLocataire() {
//		System.out.println("1 - Voir/Modifier mon profil");
//		System.out.println("2 - Voir les annonces");
//		System.out.println("3 - Lire mes messages");
//		System.out.println("4 - Envoyer un message");
//		System.out.println("5 - Noter un appartement");
//		System.out.println("6 - Se deconnecter");
//		System.out.println("7 - STOP");
//		
//		int choix = Context.getInstance().saisieInt("Choisir un menu :");
//		switch(choix)
//		{
//		case 1 : modifierProfil();break;
//		case 2 : voirAnnonce();break;
//		case 3 : afficherListeMessageRecus();break;
//		case 4 : envoyerMessage();break;
//		case 5 : noterAppart();break;
//		case 6 : System.out.println("Deconnexion...");Context.getInstance().setUtisateurConnecte(null);connexion();break;
//		case 7 : System.exit(0);
//		}
//	}
//	
//	public static void menuProprietaire() {
//		System.out.println("1 - Voir/Modifier mon profil");
//		System.out.println("2 - Ajouter un logement");
//		System.out.println("3 - Voir/Modifier un logement");
//		System.out.println("4 - Voir les dossiers de candidature");
//		System.out.println("5 - Modifier les disponibilit�s d'un logement");
//		System.out.println("6 - Lire mes messages");
//		System.out.println("7 - Ecrire un message");
//		System.out.println("8 - Se deconnecter");
//		System.out.println("9 - Stop");
//		
//		int choix = Context.getInstance().saisieInt("Choisir un menu :");
//		switch(choix)
//		{
//		case 1 : modifierProfil();break;
//		case 2 : ajoutAppart();break;
//		case 3 : modifAppart();break;
//		case 4 : validerDossier();break;
//		case 5 : rendreDispo();break;
//		case 6 : envoyerMessage();break;
//		case 7 : afficherListeMessageRecus();break;
//		case 8 : System.out.println("Deconnexion...");Context.getInstance().setUtisateurConnecte(null);connexion();break;
//		case 9 : System.exit(0);
//		}
//	}
	
	Logement logement1 = new Logement();
	
	Context.getInstance().getDaoLogement().save(logement1);
	

	Proprio proprio1 = new Proprio();
	Locataire loc1 = new Locataire();
	Context.getInstance().getDaoProprio().save(proprio1);
	Context.getInstance().getDaoLocataire().save(loc1);
	
	Context.getInstance().closeEmf();
	
	}	
	
}
