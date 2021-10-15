package dao;

import model.utilisateur.Utilisateur;

public interface IDAOUtilisateur extends IDAO<Utilisateur,Integer>{

	public Utilisateur connect(String email, String password);
	public Utilisateur findByEmail(String email);
}
