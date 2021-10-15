package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;

import dao.IDAOProprio;
import model.utilisateur.Proprio;


public class DAOProprio implements IDAOProprio {

	@Override
	public Proprio findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Proprio objet = em.find(Proprio.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Proprio> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Proprio p ",Proprio.class);
		List<Proprio> Proprios = requete.getResultList();
		em.close();
		return Proprios;
	}


	@Override
	public Proprio save(Proprio o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Proprio o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
}
