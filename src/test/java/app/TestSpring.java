package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coloc.repository.IDAOChambre;
import coloc.repository.IDAOCommodite;
import coloc.repository.IDAODossier;
import coloc.repository.IDAOLocalisation;
import coloc.repository.IDAOLocataire;
import coloc.repository.IDAOLogement;
import coloc.repository.IDAOMessage;
import coloc.repository.IDAONotation;
import coloc.repository.IDAOProprio;
import coloc.repository.IDAORegle;
import coloc.repository.IDAOUtilisateur;
import config.ApplicationConfig;

public class TestSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IDAOChambre chambreRepository = spring.getBean(IDAOChambre.class);
		IDAOCommodite commoditeRepository = spring.getBean(IDAOCommodite.class);
		IDAODossier dossierRepository = spring.getBean(IDAODossier.class);
		IDAOLocalisation localisationRepository = spring.getBean(IDAOLocalisation.class);
		IDAOLocataire locataireRepository = spring.getBean(IDAOLocataire.class);
		IDAOLogement logementRepository = spring.getBean(IDAOLogement.class);
		IDAOMessage messageRepository = spring.getBean(IDAOMessage.class);
		IDAONotation notationRepository = spring.getBean(IDAONotation.class);
		IDAOProprio proprioRepository = spring.getBean(IDAOProprio.class);
		IDAORegle regleRepository = spring.getBean(IDAORegle.class);
		IDAOUtilisateur utilisateurRepository = spring.getBean(IDAOUtilisateur.class);

		spring.close();
	}

}
