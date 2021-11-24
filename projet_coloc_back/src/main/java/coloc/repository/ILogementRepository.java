package coloc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface ILogementRepository extends JpaRepository<Logement,Long>{

	//public List<Logement> findAllByIdProprio(int idProprio);
	//public List<Logement> findAllByAvailabilityWithProprio();
}
