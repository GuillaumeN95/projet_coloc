package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOChambre;
import dao.IDAOCommodite;
import dao.IDAODossier;
import dao.IDAOLocalisation;
import dao.IDAOLocataire;
import dao.IDAOLogement;
import dao.IDAOMessage;
import dao.IDAOProprio;
import dao.IDAORegle;
import dao.IDAOUtilisateur;
import dao.jpa.DAOChambre;
import dao.jpa.DAOCommodite;
import dao.jpa.DAODossier;
import dao.jpa.DAOLocalisation;
import dao.jpa.DAOLocataire;
import dao.jpa.DAOLogement;
import dao.jpa.DAOMessage;
import dao.jpa.DAOProprio;
import dao.jpa.DAORegle;
import dao.jpa.DAOUtilisateur;


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
	private IDAOUtilisateur daoUtilisateur = new DAOUtilisateur();
	
	

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



	public IDAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}



	public void closeEmf() 
	{
		this.emf.close();
	}

	
	
	
	
}
