package coloc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface IDAOMessage extends JpaRepository<Message,Integer>{

	//public List<Message> findAllByIdDestinataireWithUtilisateur(int idDestinataire);
	//public List<Message> findAllByIdEmetteurWithUtilisateur(int idEmetteur);
	//public Message findByIdWithUtilisateur(int idMessage);
}
