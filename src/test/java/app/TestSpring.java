package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coloc.repository.*;
import coloc.model.*;
import config.ApplicationConfig;

public class TestSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IChambreRepository chambreRepository = spring.getBean(IChambreRepository.class);
		ICommoditeRepository commoditeRepository = spring.getBean(ICommoditeRepository.class);
		IDossierRepository dossierRepository = spring.getBean(IDossierRepository.class);
		ILocalisationRepository localisationRepository = spring.getBean(ILocalisationRepository.class);
		ILocataireRepository locataireRepository = spring.getBean(ILocataireRepository.class);
		ILogementRepository logementRepository = spring.getBean(ILogementRepository.class);
		IMessageRepository messageRepository = spring.getBean(IMessageRepository.class);
		INotationRepository notationRepository = spring.getBean(INotationRepository.class);
		IProprioRepository proprioRepository = spring.getBean(IProprioRepository.class);
		IRegleRepository regleRepository = spring.getBean(IRegleRepository.class);
		IUtilisateurRepository utilisateurRepository = spring.getBean(IUtilisateurRepository.class);

		spring.close();
	}

}
