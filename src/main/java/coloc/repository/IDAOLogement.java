package coloc.repository;

import java.util.List;

import coloc.model.*;

public interface IDAOLogement extends IDAO<Logement,Integer>{

	public List<Logement> findAllByIdProprio(int idProprio);
	public List<Logement> findAllByAvailabilityWithProprio();
}
