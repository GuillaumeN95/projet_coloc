package app;

import java.util.ArrayList;
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
	 * Methodes des menus
	 */
	
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
		case 6 : System.out.println("Deconnexion...");Context.getInstance().setUtilisateurConnecte(null);connexion();break;
		case 7 : System.exit(0);
		}
	}
	
	public static void menuProprietaire() {
		System.out.println("1 - Voir/Modifier mon profil");
		System.out.println("2 - Ajouter un logement");
		System.out.println("3 - Voir/Modifier un logement");
		System.out.println("4 - Voir les dossiers de candidature");
		System.out.println("5 - Modifier les disponibilites d'un logement");
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
		case 8 : System.out.println("Deconnexion...");Context.getInstance().setUtilisateurConnecte(null);connexion();break;
		case 9 : System.exit(0);
		}
	}
	
	public static void retourMenu() {
		// Retour au menu correspondant à l'utilisateur connecté (Proprio / Locataire)
		int retourMenu = Context.getInstance().saisieInt("Voulez vous : 1 - Afficher la liste des messages reçus | 2 - Revenir au menu : ");
		if(retourMenu==1) {
			afficherListeMessageRecus();
		} else {
			if(Context.getInstance().getUtilisateurConnecte() instanceof Locataire) {
				menuLocataire();
			}
			menuProprietaire();
		}
	}
	
	public static void connexion() {
		// Permet de se connecter a un compte utilisateur et mettre l'utlisiteur dans le contexte
		String email = Context.getInstance().saisieString("Saisir votre email : ");
		String password = Context.getInstance().saisieString("Saisir votre password : ");
		
		Utilisateur connexion = Context.getInstance().getDaoUtilisateur().connect(email,password);
		if(connexion == null) {
			System.out.println("Utilisateur non reconnu");
			connexion();
		}
		Context.getInstance().setUtilisateurConnecte(connexion);
		//
		if(connexion instanceof Locataire) {menuLocataire();}
		else if(connexion instanceof Proprio) {menuProprietaire();}
		else {System.out.println("Identifiants invalides");connexion();}
	}
	
	/*
	 * Methodes comptes
	 */
	
	public static void creerCompte() {
		
	}
	
	public static void modifierProfil() {
		
		Utilisateur connected = Context.getInstance().getUtilisateurConnecte();
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
	 * Methodes messages
	 */
	
	public static void afficherListeMessageRecus() {
		// Affiche la liste des messages reçus
		List<Message> messages = Context.getInstance().getDaoMessage().findAllByIdDestinataire(Context.getInstance().getUtilisateurConnecte().getId());
		for(Message m : messages) {
			System.out.println("Message numero " + m.getId() + " de " + m.getEmetteur().getNom() + " " + m.getEmetteur().getPrenom());
		}
		String choix = Context.getInstance().saisieString("Voulez vous lire un message : (O/N)");
		if(choix.toUpperCase().equals("O")) {
			int idMessage = Context.getInstance().saisieInt("Entrez le numero du message que vous souhaitez lire : ");
			afficherMessage(idMessage);
		} else {
			retourMenu();
		}
	}
	
	public static void afficherListeMessageEnvoyes() {
		// Affiche la liste des messages envoyes
		List<Message> messages = Context.getInstance().getDaoMessage().findAllByIdEmetteur(Context.getInstance().getUtilisateurConnecte().getId());
		for(Message m : messages) {
			System.out.println("Message numero " + m.getId() + " a " + m.getDestinataire().getNom() + " " + m.getDestinataire().getPrenom());
		}
	}
	
	public static void afficherMessage(int idMessage) {
		// Affiche un message par son id dans la BDD
		Message message = Context.getInstance().getDaoMessage().findById(idMessage);
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
		Message message = Context.getInstance().getDaoMessage().findById(idMessage);
		Context.getInstance().getDaoMessage().delete(message);
		System.out.println("Message supprime");
	}
	
	public static void envoyerMessage() {
		// Envoie un nouveau message
		String mailDestinataire = Context.getInstance().saisieString("Entrez l'email du destinataire : ");
		Utilisateur destinataire = Context.getInstance().getDaoUtilisateur().findByEmail(mailDestinataire);
		if(destinataire == null) {
			System.out.println("L'adresse mail saisie ne correspond a aucun utilisateur.");
			envoyerMessage();
		}
		String contenu = Context.getInstance().saisieString("Saissisez votre message : ");
		Message newMessage = new Message(Context.getInstance().getUtilisateurConnecte(), destinataire, contenu);
		newMessage = Context.getInstance().getDaoMessage().save(newMessage);
		System.out.println("Message envoye");
		retourMenu();
	}

	/*
	 * Methodes appartement
	 */
	
	public static void rendreDispo() {
		List<Logement> logementsDuProprio = Context.getInstance().getDaoLogement().findAllByIdProprio(Context.getInstance().getUtilisateurConnecte().getId());
		System.out.println("Voici la liste de vos logements : ");
		for(Logement l : logementsDuProprio) {
			System.out.println("Logement numero " + l.getId() + " situé " + l.getLocalisation().getNum() + " " + l.getLocalisation().getVoie() + " " + l.getLocalisation().getVille());
		}
		int choix = Context.getInstance().saisieInt("Dans quel logement souhaitez vous liberer une chambre : ");
		Logement logementALiberer = Context.getInstance().getDaoLogement().findById(choix);
		List<Chambre> chambresDuLogement = Context.getInstance().getDaoChambre().findAllByIdLogement(logementALiberer.getId());
		System.out.println("Voici les chambres du logement : ");
		List<Locataire> locatairesDesChambres = new ArrayList();
		for(Chambre c : chambresDuLogement) {
			Locataire loc = Context.getInstance().getDaoLocataire().findByIdChambre(c.getId());
			locatairesDesChambres.add(loc);
			if(loc == null) {
				System.out.println("Chambre numero " + c.getId() + "inoccupee");
			} else {
				System.out.println("Chambre numero " + c.getId() + " occupee par " + loc.getNom() + " " + loc.getPrenom());
			}
		choix = Context.getInstance().saisieInt("Quelle chambre souhaitez vous liberer : ");
		Chambre chambreALiberer = Context.getInstance().getDaoChambre().findById(choix);
		Locataire locataireChambreALiberer = Context.getInstance().getDaoLocataire().findByIdChambre(choix);
		locataireChambreALiberer.setChambre(null);
		chambreALiberer.setLocataire(null);
		Context.getInstance().getDaoChambre().save(chambreALiberer);
		Context.getInstance().getDaoLocataire().save(locataireChambreALiberer);
		retourMenu();
		}
	}
	
	/*
	 *  Main
	 */
	
	public static void main(String[] args) {

//		menuPrincipal();

	Logement logement1 = new Logement();
	
	Context.getInstance().getDaoLogement().save(logement1);
	

	Proprio proprio1 = new Proprio();
	Locataire loc1 = new Locataire();
	Context.getInstance().getDaoProprio().save(proprio1);
	Context.getInstance().getDaoLocataire().save(loc1);
	
	Context.getInstance().closeEmf();
	
	}	
	
}
