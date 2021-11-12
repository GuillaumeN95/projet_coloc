package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import coloc.model.*;
import coloc.repository.IDAOChambre;
import util.Context;

public class DAOChambre implements IDAOChambre {

	@Override
	public Chambre findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Chambre objet = em.find(Chambre.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Chambre> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Chambre c",Chambre.class);
		List<Chambre> Chambres = requete.getResultList();
		em.close();
		return Chambres;
	}


	@Override
	public Chambre save(Chambre o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Chambre o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Chambre> findAllByIdLogement(int idLogement) {
		Logement logement = Context.getInstance().getDaoLogement().findById(idLogement);
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("from Chambre c where c.logement = :logement", Chambre.class);
		query.setParameter("logement", logement);
		List<Chambre> chambres = query.getResultList();
		em.close();
		return chambres;
	}
	
}
