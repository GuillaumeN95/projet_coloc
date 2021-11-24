package coloc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface IChambreRepository extends JpaRepository<Chambre,Long>{

	//public List<Chambre> findAllByIdLogement(int idLogement);
}
