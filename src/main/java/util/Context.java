package util;

import java.util.Scanner;

import model.utilisateur.Utilisateur;

public class Context {

	//SINGLETON
	private static Context _instance;
	private Utilisateur utisateurConnecte = null;
	private IDAOMessage daoMessage = new DAOMessage();
	private IDAOUtilisateur doaUtilisateur = new DAOMessage();
	
	private Context() {}
	
	public static Context getInstance() 
	{
		if(_instance==null)
		{_instance=new Context();}
		
		return _instance;
	}
	//FIN SINGLETON

	public String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}

	public int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public Utilisateur getUtisateurConnecte() {
		return utisateurConnecte;
	}

	public void setUtisateurConnecte(Utilisateur utisateurConnecte) {
		this.utisateurConnecte = utisateurConnecte;
	}
	
}

