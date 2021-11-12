package dao.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import coloc.model.logement.Logement;
import coloc.model.utilisateur.Proprio;
import coloc.model.utilisateur.Utilisateur;
import coloc.repository.IDAOLogement;
import util.Context;

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
	
	public List<Logement> findAllByAvailabilityWithProprio() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("from Logement l LEFT JOIN fetch l.proprietaire where :date > l.dateDispo", Logement.class);
		query.setParameter("date", LocalDate.now());
		List<Logement> logements = query.getResultList();
		em.close();
		return logements;
	}
	
}
