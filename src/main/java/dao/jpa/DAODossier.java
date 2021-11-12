package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import coloc.model.logement.Logement;
import coloc.model.utilisateur.Dossier;
import coloc.model.utilisateur.Proprio;
import coloc.repository.IDAODossier;
import util.Context;

public class DAODossier implements IDAODossier {

	@Override
	public Dossier findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Dossier objet = em.find(Dossier.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Dossier> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Dossier d",Dossier.class);
		List<Dossier> Dossiers = requete.getResultList();
		em.close();
		return Dossiers;
	}


	@Override
	public Dossier save(Dossier o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Dossier o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}
