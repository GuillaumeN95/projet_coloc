package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;

import dao.IDAOMessage;
import model.Message;

public class DAOMessage implements IDAOMessage {

	@Override
	public Message findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Message objet = em.find(Message.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Message> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Message m ",Message.class);
		List<Message> Messages = requete.getResultList();
		em.close();
		return Messages;
	}


	@Override
	public Message save(Message o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Message o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
}
