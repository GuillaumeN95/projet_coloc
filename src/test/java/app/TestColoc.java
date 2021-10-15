package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;

import model.*;
import model.logement.Chambre;
import model.logement.Localisation;
import model.logement.Logement;
import model.logement.Notation;
import model.logement.TypeLogement;
import model.utilisateur.*;
import util.Context;

public class TestColoc {
	
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
		case 6 : System.out.println("Deconnexion...");Context.getInstance().setUtilisateurConnecte(null);menuPrincipal();break;
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
		case 8 : System.out.println("Deconnexion...");Context.getInstance().setUtilisateurConnecte(null);menuPrincipal();break;
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
		boolean nouveauMail = false;
		System.out.println("Creation de compte :");
		String nom = Context.getInstance().saisieString("Entrez votre nom : ");
		String prenom = Context.getInstance().saisieString("Entrez votre prenom : ");
		System.out.println("Voici les civilités disponibles : ");
		for(Civilite civ : Civilite.values()) {System.out.println(civ);}
		Civilite civ = Civilite.valueOf(Context.getInstance().saisieString("Choisissez votre civilite : "));
		String email = "";
		while(!nouveauMail) {
			email = Context.getInstance().saisieString("Entrez votre email : ");
			Utilisateur utilisateurExistant = Context.getInstance().getDaoUtilisateur().findByEmail(email);
			if(utilisateurExistant != null) {
				System.out.println("Un compte est deja existant pour cet email.");
			} else {
				nouveauMail = true;
			}
		}
		String tel = Context.getInstance().saisieString("Entrez votre numero de telephone : ");
		String password = Context.getInstance().saisieString("Entrez votre mot de passe : ");
		int choixTypeCompte = Context.getInstance().saisieInt("Etes vous 1-Proprietaire ou 2-Locataire :");
		if(choixTypeCompte == 1) {
			Proprio proprioACreer = new Proprio(nom, prenom, civ, email, tel, password, null);
			Context.getInstance().getDaoProprio().save(proprioACreer);
		}else{
			String choixRecherche = Context.getInstance().saisieString("Etes vous en recherche de colocation (O/N) : ");
			boolean recherche = false;
			if(choixRecherche.toLowerCase().equals("o")) {recherche = true;}
			System.out.println("Voici les situtations disponibles : ");
			for(Situation sit : Situation.values()) {System.out.println(sit);}
			Situation situation = Situation.valueOf(Context.getInstance().saisieString("Choisissez votre situation : "));
			String description = Context.getInstance().saisieString("Saisissez votre description : ");
			Locataire locataireACreer = new Locataire(nom, prenom, civ, email, tel, password, recherche, description, situation, null, null);
			Context.getInstance().getDaoLocataire().save(locataireACreer);
		}
		System.out.println("Profil cree");
		menuPrincipal();
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
			modif = Context.getInstance().saisieString("Saisir la modif");
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
	 * Methodes logement
	 */
	
	
	public static void ajoutAppart() {
		
		System.out.println("Ajout d'un nouveau logement");
		
		
		/* Localisation */
		
		System.out.println("Localisation de l'appartement : ");
		
		String villeNew = Context.getInstance().saisieString("Ajouter la ville : ");
		String codePostalNew = Context.getInstance().saisieString("Ajouter le code postal (Entrer pour passer)");
		
		String voieNew="";
		String departementNew ="";
		int numNew;
	
		departementNew = Context.getInstance().saisieString("Ajouter le departement (Entrer pour passer)");
		voieNew = Context.getInstance().saisieString("Ajouter le nom de la voie (Entrer pour passer)");
		numNew = Context.getInstance().saisieInt("Ajouter le numero de la voie (Entrer pour passer)");
		
		Localisation newLocalisation = new Localisation(departementNew,villeNew,codePostalNew,voieNew,numNew);
		newLocalisation = Context.getInstance().getDaoLocalisation().save(newLocalisation);
		
		
		
		/* Type logement */
		
		
		
		System.out.println("Type de logement : ");
		
		TypeLogement[] typeLogement = TypeLogement.values();
		for(int i=0;i<typeLogement.length;i++)
		{
			System.out.println( typeLogement[i]);
		}
		
		String typeNew="";
		String choix="o";

		while(choix.equals("o"))
		{
			try 
			{
				typeNew = Context.getInstance().saisieString("Entrer le type du logement : ");
				for(TypeLogement t : typeLogement)
				{
					if(typeNew.equals(t.toString())) {choix="n";}
				}
			}
			catch(Exception e) {System.out.println("Erreur : entrer un type d'appartement");}
			if(choix.equals("o")){System.out.println("Erreur dans la saisie");}
		}
		
		
		
		/* INFOS Logement */
		
		
		
		System.out.println("Informations sur le logement : ");
		
		boolean fin=false;
		int surface=0;
		Double loyer=0.0;
		do {
			try 
			{
				surface = Context.getInstance().saisieInt("Entrer la surface totale du logement (m�) : ");
				loyer = Context.getInstance().saisieDouble("Entrer le loyer : ");
				fin = true;
			}
			catch(Exception e) {System.out.println("Erreur : entrer uniquement nombres");}
		}
		while(!fin);
		
		
		String testMeuble = Context.getInstance().saisieString("Le logement est-il meuble (o/n)");
		boolean meuble;
		if(testMeuble.equals("o")) {meuble=true;}else {meuble=false;}
		
		int nbChambre = Context.getInstance().saisieInt("Entrer le nombre de chambre : ");
		int nbChambreOccup = Context.getInstance().saisieInt("Entrer le nombre de chambre occupee : ");
		int nbSdB = Context.getInstance().saisieInt("Entrer le nombre de salle de bain : ");
		
		
		
		//Commodites
		
		
		
//		String commodite = Context.getInstance().saisieString("Ajouter d'autres commoditees au logement (o/n)? (balcon, terrasse, WiFi, cave,...)");
//		
//		List<Commodite> listeCommodites = new ArrayList();
//		
//		if(commodite.equals("o")) {System.out.println("Ajouter les commodites une par une (STOP pour finir) :");}
//		while(!(commodite.equals("STOP")))
//		{
//			commodite = Context.getInstance().saisieString("- " );
//			if(!(commodite.equals("STOP"))) 
//			{
//				Commodite newCommodite = new Commodite(commodite);
//				Context.getInstance().getDaoCommodite().save(newCommodite);
//				listeCommodites.add(newCommodite);
//			}
//		}
		
		
		
		//Description
		
		
		String description = Context.getInstance().saisieString("Ajouter un texte de description � l'appartement (o/n) ?");
		
		if(description.equals("o"))
		{
			description = Context.getInstance().saisieString("Entrer la description : ");
		}
		else {description = "";}
		
		
		

		//Regles
		
		
		
//		String regle = Context.getInstance().saisieString("Ajouter des regles � l'appartement (o/n) ?");
//		List<Regle> listeRegles = new ArrayList();
//		
//		if(regle.equals("o")) {System.out.println("Ajouter les regles une par une (STOP pour finir) :");}
//		while(!(commodite.equals("STOP")))
//		{
//			regle = Context.getInstance().saisieString("- " );
//			if(!(regle.equals("STOP"))) 
//			{
//				Regle newRegle = new Regle(regle);
//				Context.getInstance().getDaoRegle().save(newRegle);
//				listeRegles.add(newRegle);
//			}
//		}
		
		
		
		Logement newLogement = new Logement(description,surface,nbChambre,newLocalisation);
		newLogement = Context.getInstance().getDaoLogement().save(newLogement);
		
		
		
		//CARACTERISTIQUES Chambres
		
		
		
		System.out.println("Caract�ristiques des chambres : ");
		
		String chambre = Context.getInstance().saisieString("Renseigner les chambres (o/n) ? ");
		
		List<Chambre> listeChambres = new ArrayList();
		
		
		if(chambre.equals("o"))
		{
			for(int i=1;i<=nbChambre;i++)
			{
				System.out.println("Chambre n� " + i);
				int surfaceChambre = Context.getInstance().saisieInt("Surface : ");
				Double loyerChambre = Context.getInstance().saisieDouble("Loyer : ");
				Double cautionChambre = Context.getInstance().saisieDouble("Caution : ");
				int dureeMiniChambre = Context.getInstance().saisieInt("Duree mini de location : ");
				Chambre newChambre = new Chambre(newLogement,surfaceChambre,loyerChambre,cautionChambre);
				newChambre = Context.getInstance().getDaoChambre().save(newChambre);
			}
		}
		
		
		
	}
	
	
	
	
	
	
	/*
	 *  Main
	 */
	
	public static void main(String[] args) {
		
		ajoutAppart();
	
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
	
	
	
	}	
	
}
