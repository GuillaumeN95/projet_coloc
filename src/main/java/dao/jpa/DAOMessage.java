package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import coloc.model.Message;
import coloc.repository.IDAOMessage;
import util.Context;

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
		List<Message> messages = requete.getResultList();
		em.close();
		return messages;
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

	@Override
	public List<Message> findAllByIdDestinataireWithUtilisateur(int idDestinataire) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Message m LEFT JOIN fetch m.emetteur WHERE m.destinataire = :destinataire",Message.class);
		requete.setParameter("destinataire", Context.getInstance().getDaoUtilisateur().findById(idDestinataire));
		List<Message> messages = requete.getResultList();
		requete = em.createQuery("from Message m LEFT JOIN fetch m.destinataire WHERE m.destinataire = :destinataire",Message.class);
		requete.setParameter("destinataire", Context.getInstance().getDaoUtilisateur().findById(idDestinataire));
		messages = requete.getResultList();
		em.close();
		return messages;
	}

	@Override
	public List<Message> findAllByIdEmetteurWithUtilisateur(int idEmetteur) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Message m LEFT JOIN fetch m.emetteur WHERE m.emetteur = :emetteur",Message.class);
		requete.setParameter("emetteur", Context.getInstance().getDaoUtilisateur().findById(idEmetteur));
		List<Message> messages = requete.getResultList();
		requete = em.createQuery("from Message m LEFT JOIN fetch m.destinataire WHERE m.emetteur = :emetteur",Message.class);
		requete.setParameter("emetteur", Context.getInstance().getDaoUtilisateur().findById(idEmetteur));
		messages = requete.getResultList();
		em.close();
		return messages;
	}

	@Override
	public Message findByIdWithUtilisateur(int idMessage) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Message m LEFT JOIN fetch m.emetteur WHERE m.id = :idMessage",Message.class);
		requete.setParameter("idMessage", idMessage);
		Message message = (Message) requete.getSingleResult();
		em.close();
		return message;
	}
	
}
