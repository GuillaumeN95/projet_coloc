package coloc.repository;

import java.util.List;

import coloc.model.*;

public interface IDAOMessage extends IDAO<Message,Integer>{

	public List<Message> findAllByIdDestinataireWithUtilisateur(int idDestinataire);
	public List<Message> findAllByIdEmetteurWithUtilisateur(int idEmetteur);
	public Message findByIdWithUtilisateur(int idMessage);
}
