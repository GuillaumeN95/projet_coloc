package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import coloc.model.logement.Notation;
import coloc.repository.IDAONotation;
import util.Context;

public class DAONotation implements IDAONotation {

	@Override
	public Notation findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Notation objet = em.find(Notation.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Notation> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Notation c",Notation.class);
		List<Notation> Notations = requete.getResultList();
		em.close();
		return Notations;
	}


	@Override
	public Notation save(Notation o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Notation o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
}
