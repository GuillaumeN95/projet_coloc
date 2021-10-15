package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;

import dao.IDAOLocataire;
import model.logement.Chambre;
import model.logement.Logement;
import model.utilisateur.Locataire;
import model.utilisateur.Proprio;

public class DAOLocataire implements IDAOLocataire {

	@Override
	public Locataire findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Locataire objet = em.find(Locataire.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Locataire> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Locataire l ",Locataire.class);
		List<Locataire> Locataires = requete.getResultList();
		em.close();
		return Locataires;
	}


	@Override
	public Locataire save(Locataire o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Locataire o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Locataire findByIdChambre(int idChambre) {
		Chambre chambre = Context.getInstance().getDaoChambre().findById(idChambre);
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("from Locataire l where l.chambre = :chambre", Locataire.class);
		query.setParameter("chambre", chambre);
		List<Locataire> locataire = query.getResultList();
		em.close();
		if(locataire.size() == 0) {
			return null;
		}
		return locataire.get(0);
	}
	
}
