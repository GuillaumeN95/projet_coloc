package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;

import dao.IDAOCommodite;
import model.logement.Commodite;

public class DAOCommodite implements IDAOCommodite {

	@Override
	public Commodite findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Commodite objet = em.find(Commodite.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Commodite> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Commodite c",Commodite.class);
		List<Commodite> Commodites = requete.getResultList();
		em.close();
		return Commodites;
	}


	@Override
	public Commodite save(Commodite o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Commodite o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
}
