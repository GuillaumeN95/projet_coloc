package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coloc.init.InitDb;
import coloc.repository.*;
import config.ApplicationConfig;

public class TestSpring {

	public static void main(String[] args) {
		// Creation de la base de donnees
		InitDb.run();

/*		AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        IUtilisateurRepository utilisateurRepository = spring.getBean(IUtilisateurRepository.class);
        IProprietaireRepository proprietaireRepository = spring.getBean(IProprietaireRepository.class);
		ILocataireRepository locataireRepository = spring.getBean(ILocataireRepository.class);
		ILogementRepository logementRepository = spring.getBean(ILogementRepository.class);
        IChambreRepository chambreRepository = spring.getBean(IChambreRepository.class);
		IMessageRepository messageRepository = spring.getBean(IMessageRepository.class);
		INotationRepository notationRepository = spring.getBean(INotationRepository.class);
		IRegleRepository regleRepository = spring.getBean(IRegleRepository.class);
        ICommoditeRepository commoditeRepository = spring.getBean(ICommoditeRepository.class);
        IPhotoRepository photoRepository = spring.getBean(IPhotoRepository.class);

		spring.close();
	*/	}
}
