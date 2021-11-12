package coloc.repository;

import coloc.model.*;

public interface IDAOLocataire extends IDAO<Locataire,Integer>{

	public Locataire findByIdChambre(int idChambre);
}
