package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import coloc.model.logement.Regle;
import coloc.repository.IDAORegle;
import util.Context;

public class DAORegle implements IDAORegle {

	@Override
	public Regle findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Regle objet = em.find(Regle.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Regle> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Regle r ",Regle.class);
		List<Regle> Regles = requete.getResultList();
		em.close();
		return Regles;
	}


	@Override
	public Regle save(Regle o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Regle o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
}
