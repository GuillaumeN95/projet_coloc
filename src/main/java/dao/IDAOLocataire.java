package dao;

import model.utilisateur.Locataire;

public interface IDAOLocataire extends IDAO<Locataire,Integer>{

	public Locataire findByIdChambre(int idChambre);
}
