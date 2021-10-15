package dao;

import java.util.List;

import model.logement.Chambre;

public interface IDAOChambre extends IDAO<Chambre,Integer>{

	public List<Chambre> findAllByIdLogement(int idLogement);
}
