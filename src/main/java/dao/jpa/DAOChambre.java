package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOChambre;
import model.logement.Chambre;
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
	
}
