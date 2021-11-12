package coloc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface IDAOChambre extends JpaRepository<Chambre,Integer>{

	//public List<Chambre> findAllByIdLogement(int idLogement);
}
