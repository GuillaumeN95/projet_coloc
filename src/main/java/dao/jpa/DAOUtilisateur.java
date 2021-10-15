package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;

import dao.IDAOUtilisateur;
import model.utilisateur.Utilisateur;

public class DAOUtilisateur implements IDAOUtilisateur {

	@Override
	public Utilisateur findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Utilisateur objet = em.find(Utilisateur.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Utilisateur> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Utilisateur r ",Utilisateur.class);
		List<Utilisateur> Utilisateurs = requete.getResultList();
		em.close();
		return Utilisateurs;
	}


	@Override
	public Utilisateur save(Utilisateur o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Utilisateur o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public Utilisateur findByEmail(String email) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("from Utilisateur u where u.email = :email", Utilisateur.class);
		query.setParameter("email", email);
		List<Utilisateur> utilisateur = query.getResultList();
		em.close();
		if(utilisateur.size()==0) {
			return null;
		}
		return utilisateur.get(0);
	}

	@Override
	public Utilisateur connect(String email, String password) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = findByEmail(email);
		if(utilisateur.getEmail().equals(email) && utilisateur.getPassword().equals(password)) {
			return utilisateur;
		}
		return null;
	}
	
}
