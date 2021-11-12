package coloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface IDAOLocataire extends JpaRepository<Locataire,Integer>{

	//public Locataire findByIdChambre(int idChambre);
}
