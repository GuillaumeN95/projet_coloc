package app;

import java.util.Scanner;

import model.Medecin;
import model.Secretaire;

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
	
	
	public static void main(String[] args) {
	
		menuPrincipal();
	}
	
	
	
	
	public static void menuPrincipal() {
		System.out.println("1 - Se connecter");
		System.out.println("2 - Creer un compte");
		System.out.println("3 - STOP");
	
		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : creerCompte();break;
		case 3 : System.exit(0);
		}
		menuPrincipal();
	}

	
	
	public static void connexion() {
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		
		//A MODIFER
		connexion = daoCompte.connect(login,password);
		//
		if(connexion instanceof Locataire) {menuLocataire();}
		else if(connexion instanceof Proprietaire) {menuProprietaire();}
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
		
		int choix = saisieInt("Choisir un menu :");
		switch(choix)
		{
		case 1 : modifierProfil();break;
		case 2 : voirAnnonce();break;
		case 3 : lireMessage();break;
		case 4 : ecrireMessage();break;
		case 5 : noterAppart();break;
		case 6 : System.out.println("Deconnexion...");connexion();break;
		case 7 : System.exit(0);
		}
	}
	
	
	
	public static void menuProprietaire() {
		System.out.println("1 - Voir/Modifier mon profil");
		System.out.println("2 - Ajouter un logement");
		System.out.println("3 - Voir/Modifier un logement");
		System.out.println("4 - Voir les dossiers de candidature");
		System.out.println("5 - Modifier les disponibilités d'un logement");
		System.out.println("6 - Lire mes messages");
		System.out.println("7 - Ecrire un message");
		System.out.println("8 - Se deconnecter");
		System.out.println("9 - Stop");
		
		int choix = saisieInt("Choisir un menu :");
		switch(choix)
		{
		case 1 : modifierProfil();break;
		case 2 : ajoutAppart();break;
		case 3 : modifAppart();break;
		case 4 : validerDossier();break;
		case 5 : rendreDispo();break;
		case 6 : ecrireMessage();break;
		case 7 : lireMessage();break;
		case 8 : System.out.println("Deconnexion...");connexion();break;
		case 9 : System.exit(0);
		}
	}
	
	
	
}
