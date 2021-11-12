package coloc.repository;

import java.util.List;

import coloc.model.*;

public interface IDAOChambre extends IDAO<Chambre,Integer>{

	public List<Chambre> findAllByIdLogement(int idLogement);
}
