package coloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer>{

	//public Utilisateur connect(String email, String password);
	//public Utilisateur findByEmail(String email);
}
