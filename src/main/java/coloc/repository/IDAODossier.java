package coloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.model.*;

public interface IDAODossier extends JpaRepository<Dossier,Integer>{

}
