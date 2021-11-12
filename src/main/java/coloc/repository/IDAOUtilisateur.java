package coloc.repository;

import coloc.model.*;

public interface IDAOUtilisateur extends IDAO<Utilisateur,Integer>{

	public Utilisateur connect(String email, String password);
	public Utilisateur findByEmail(String email);
}
