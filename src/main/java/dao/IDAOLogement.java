package dao;

import java.util.List;

import model.logement.Logement;

public interface IDAOLogement extends IDAO<Logement,Integer>{

	public List<Logement> findAllByIdProprio(int idProprio);
	public List<Logement> findAllByAvailability();
}
