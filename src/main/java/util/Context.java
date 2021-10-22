package util;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.*;
import dao.jpa.*;
import model.utilisateur.*;


public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private IDAOChambre daoChambre= new DAOChambre();
	private IDAOCommodite daoCommodite = new DAOCommodite();
	private IDAODossier daoDossier = new DAODossier();
	private IDAOLocalisation daoLocalisation = new DAOLocalisation();
	private IDAOLocataire daoLocataire = new DAOLocataire();
	private IDAOLogement daoLogement = new DAOLogement();
	private IDAOMessage daoMessage = new DAOMessage();
	private IDAOProprio daoProprio = new DAOProprio();
	private IDAORegle daoRegle = new DAORegle();
	private IDAONotation daoNotation = new DAONotation();
	private IDAOUtilisateur daoUtilisateur = new DAOUtilisateur();
	private Utilisateur utilisateurConnecte = null;
	
	//SINGLETON
	private static Context _instance;
	
	private Context() {}
	
	public static Context getInstance() 
	{
		if(_instance==null)
		{_instance=new Context();}
		
		return _instance;
	}
	//FIN SINGLETON

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IDAOChambre getDaoChambre() {
		return daoChambre;
	}

	public IDAOCommodite getDaoCommodite() {
		return daoCommodite;
	}

	public IDAODossier getDaoDossier() {
		return daoDossier;
	}

	public IDAOLocalisation getDaoLocalisation() {
		return daoLocalisation;
	}

	public IDAOLocataire getDaoLocataire() {
		return daoLocataire;
	}

	public IDAOLogement getDaoLogement() {
		return daoLogement;
	}

	public IDAOMessage getDaoMessage() {
		return daoMessage;
	}

	public IDAOProprio getDaoProprio() {
		return daoProprio;
	}

	public IDAORegle getDaoRegle() {
		return daoRegle;
	}

	public IDAONotation getDaoNotation() {
		return daoNotation;
	}

	
	public IDAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

	public void closeEmf() 
	{
		this.emf.close();
	}

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
	 
	public Utilisateur getUtilisateurConnecte() {
		return utilisateurConnecte;
	}

	public void setUtilisateurConnecte(Utilisateur utilisateurConnecte) {
		this.utilisateurConnecte = utilisateurConnecte;
	}
	
}

