package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;

import dao.IDAOLogement;
import model.logement.Logement;
import model.utilisateur.Proprio;
import model.utilisateur.Utilisateur;

public class DAOLogement implements IDAOLogement {

	@Override
	public Logement findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Logement objet = em.find(Logement.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Logement> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Logement l",Logement.class);
		List<Logement> Logements = requete.getResultList();
		em.close();
		return Logements;
	}


	@Override
	public Logement save(Logement o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Logement o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Logement> findAllByIdProprio(int idProprio) {
		Proprio proprio = Context.getInstance().getDaoProprio().findById(idProprio);
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("from Logement l where l.proprietaire = :proprio", Logement.class);
		query.setParameter("proprio", proprio);
		List<Logement> logements = query.getResultList();
		em.close();
		return logements;
	}
	
}
