package coloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface ILocataireRepository extends JpaRepository<Locataire,Long>{

	//public Locataire findByIdChambre(int idChambre);
}
