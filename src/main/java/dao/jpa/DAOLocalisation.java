package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;

import dao.IDAOLocalisation;
import model.logement.Localisation;

public class DAOLocalisation implements IDAOLocalisation {

	@Override
	public Localisation findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Localisation objet = em.find(Localisation.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Localisation> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Localisation l",Localisation.class);
		List<Localisation> Localisations = requete.getResultList();
		em.close();
		return Localisations;
	}


	@Override
	public Localisation save(Localisation o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Localisation o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
}
