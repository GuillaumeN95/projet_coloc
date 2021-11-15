package coloc.init;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coloc.model.*;
import coloc.repository.*;
import config.ApplicationConfig;

public class InitDb {
    
    public static void run(){

        AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IChambreRepository chambreRepository = spring.getBean(IChambreRepository.class);
		ICommoditeRepository commoditeRepository = spring.getBean(ICommoditeRepository.class);
		ILocataireRepository locataireRepository = spring.getBean(ILocataireRepository.class);
		ILogementRepository logementRepository = spring.getBean(ILogementRepository.class);
		IMessageRepository messageRepository = spring.getBean(IMessageRepository.class);
		INotationRepository notationRepository = spring.getBean(INotationRepository.class);
		IProprioRepository proprioRepository = spring.getBean(IProprioRepository.class);
		IRegleRepository regleRepository = spring.getBean(IRegleRepository.class);
		IUtilisateurRepository utilisateurRepository = spring.getBean(IUtilisateurRepository.class);

        // Creation des Proprio
        Proprio proprio1 = new Proprio("NomProprio1", "PrenomProprio1", Civilite.Mr, "proprio1@mail.com", "0000000001", "proprio1");
        proprio1 = proprioRepository.save(proprio1);
        Proprio proprio2 = new Proprio("NomProprio2", "PrenomProprio2", Civilite.Mme, "proprio2@mail.com", "0000000002", "proprio2");
        proprio2 = proprioRepository.save(proprio2);
        Proprio proprio3 = new Proprio("NomProprio3", "PrenomProprio3", Civilite.Mr, "proprio3@mail.com", "0000000003", "proprio3");
        proprio3 = proprioRepository.save(proprio3);
        Proprio proprio4 = new Proprio("NomProprio4", "PrenomProprio4", Civilite.Mme, "proprio4@mail.com", "0000000004", "proprio4");
        proprio4 = proprioRepository.save(proprio4);

        // Creation des Locataire
        Locataire locataire1 = new Locataire("NomLocataire1", "PrenomLocataire1", Civilite.Mr, "locataire1@mail.com", "0011000001", "locataire1", true, "Description locataire 1", Situation.Etudiant);
        locataire1 = locataireRepository.save(locataire1);
        Locataire locataire2 = new Locataire("NomLocataire2", "PrenomLocataire2", Civilite.Mr, "locataire2@mail.com", "0011000002", "locataire2", true, "Description locataire 2", Situation.Salarie);
        locataire2 = locataireRepository.save(locataire2);
        Locataire locataire3 = new Locataire("NomLocataire3", "PrenomLocataire3", Civilite.Mme, "locataire3@mail.com", "0011000003", "locataire3", true, "Description locataire 3", Situation.Etudiant);
        locataire3 = locataireRepository.save(locataire3);
        Locataire locataire4 = new Locataire("NomLocataire4", "PrenomLocataire4", Civilite.Mr, "locataire4@mail.com", "0011000004", "locataire4", false, "Description locataire 4", Situation.Retraite);
        locataire4 = locataireRepository.save(locataire4);
        Locataire locataire5 = new Locataire("NomLocataire5", "PrenomLocataire5", Civilite.Mme, "locataire5@mail.com", "0011000005", "locataire5", false, "Description locataire 5", Situation.Etudiant);
        locataire5 = locataireRepository.save(locataire5);
        Locataire locataire6 = new Locataire("NomLocataire6", "PrenomLocataire6", Civilite.Mme, "locataire6@mail.com", "0011000006", "locataire6", true, "Description locataire 6", Situation.Etudiant);
        locataire6 = locataireRepository.save(locataire6);
        Locataire locataire7 = new Locataire("NomLocataire7", "PrenomLocataire7", Civilite.Mr, "locataire7@mail.com", "0011000007", "locataire7", true, "Description locataire 7", Situation.Salarie);
        locataire7 = locataireRepository.save(locataire7);
        Locataire locataire8 = new Locataire("NomLocataire8", "PrenomLocataire8", Civilite.Mme, "locataire8@mail.com", "0011000008", "locataire8", true, "Description locataire 8", Situation.Salarie);
        locataire8 = locataireRepository.save(locataire8);

        // Creation des Localisation
        Localisation locLog1 = new Localisation("departementLog1", "villeLog1", "cpLog1", "voieLog1", 1);
        Localisation locLog2 = new Localisation("departementLog2", "villeLog2", "cpLog2", "voieLog2", 2);
        Localisation locLog3 = new Localisation("departementLog3", "villeLog3", "cpLog3", "voieLog3", 3);
        Localisation locLog4 = new Localisation("departementLog4", "villeLog4", "cpLog4", "voieLog4", 4);

        // Creation des Logement
        Logement log1 = new Logement(proprio1, "Description log1", 70, 2, 0, 1, 300.0, 50.0, 300.0, locLog1, TypeLogement.Appartement, LocalDate.now());
        log1 = logementRepository.save(log1);
        Logement log2 = new Logement(proprio2, "Description log2", 40, 1, 0, 1, 350.0, 50.0, 350.0, locLog2, TypeLogement.Studio, LocalDate.now());
        log2 = logementRepository.save(log2);
        Logement log3 = new Logement(proprio3, "Description log3", 110, 4, 0, 1, 275.0, 50.0, 275.0, locLog3, TypeLogement.Maison, LocalDate.now());
        log3 = logementRepository.save(log3);
        Logement log4 = new Logement(proprio4, "Description log4", 35, 2, 0, 1, 325.0, 50.0, 325.0, locLog4, TypeLogement.Studio, LocalDate.now());
        log4 = logementRepository.save(log4);

        // Creation des Commodite
        Commodite balcon = new Commodite("balcon");
        balcon = commoditeRepository.save(balcon);
        Commodite jardin = new Commodite("jardin");
        jardin = commoditeRepository.save(jardin);
        Commodite terrasse = new Commodite("terrasse");
        terrasse = commoditeRepository.save(terrasse);
        Commodite handicape = new Commodite("acces handicape");
        handicape = commoditeRepository.save(handicape);
        Commodite parking = new Commodite("parking");
        parking = commoditeRepository.save(parking);
        Commodite salleDeSport = new Commodite("salle de sport");
        salleDeSport = commoditeRepository.save(salleDeSport);
        Commodite fibre = new Commodite("internet fibre");
        fibre = commoditeRepository.save(fibre);
        Commodite climatisation = new Commodite("climatisation");
        climatisation = commoditeRepository.save(climatisation);
        Commodite television = new Commodite("television");
        television = commoditeRepository.save(television);
        Commodite laveLinge = new Commodite("lave linge");
        laveLinge = commoditeRepository.save(laveLinge);

        // Creation des Regle
        Regle fumeurAutorise = new Regle("fumeur autorise");
        fumeurAutorise = regleRepository.save(fumeurAutorise);
        Regle animauxAutorises = new Regle("animaux autorises");
        animauxAutorises = regleRepository.save(animauxAutorises);
        Regle femmeUniquement = new Regle("femme uniquement");
        femmeUniquement = regleRepository.save(femmeUniquement);
        Regle hommeUniquement = new Regle("homme uniquement");
        hommeUniquement = regleRepository.save(hommeUniquement);
        Regle passSanitaire = new Regle("pass sanitaire");
        passSanitaire = regleRepository.save(passSanitaire);

        // Creation des Notation
        Notation noteLoc1Lg1 = new Notation(log1, locataire1, 15.0, "commentaire note loc1 pour log1");
        noteLoc1Lg1 = notationRepository.save(noteLoc1Lg1);
        Notation noteLoc2Lg1 = new Notation(log1, locataire2, 10.0, "commentaire note loc2 pour log1");
        noteLoc2Lg1 = notationRepository.save(noteLoc2Lg1);
        Notation noteLoc3Lg2 = new Notation(log2, locataire3, 7.0, "commentaire note loc3 pour log2");
        noteLoc3Lg2 = notationRepository.save(noteLoc3Lg2);
        Notation noteLoc4Lg2 = new Notation(log2, locataire4, 15.0, "commentaire note loc4 pour log2");
        noteLoc4Lg2 = notationRepository.save(noteLoc4Lg2);
        Notation noteLoc5Lg4 = new Notation(log4, locataire5, 18.0, "commentaire note loc5 pour log4");
        noteLoc5Lg4 = notationRepository.save(noteLoc5Lg4);
        Notation noteLoc6Lg4 = new Notation(log4, locataire6, 10.0, "commentaire note loc5 pour log4");
        noteLoc6Lg4 = notationRepository.save(noteLoc6Lg4);
        Notation noteLoc7Lg4 = new Notation(log4, locataire7, 11.0, "commentaire note loc5 pour log4");
        noteLoc7Lg4 = notationRepository.save(noteLoc7Lg4);
        Notation noteLoc8Lg4 = new Notation(log4, locataire8, 8.0, "commentaire note loc5 pour log4");
        noteLoc8Lg4 = notationRepository.save(noteLoc8Lg4);

        Chambre ch1Log1 = new Chambre(log1, 12);
        ch1Log1 = chambreRepository.save(ch1Log1);
        Chambre ch2Log1 = new Chambre(log1, 13);
        ch2Log1 = chambreRepository.save(ch2Log1);
        Chambre ch1Log2 = new Chambre(log2, 15);
        ch1Log2 = chambreRepository.save(ch1Log2);
        Chambre ch1Log3 = new Chambre(log3, 10);
        ch1Log3 = chambreRepository.save(ch1Log3);
        Chambre ch2Log3 = new Chambre(log3, 12);
        ch2Log3 = chambreRepository.save(ch2Log3);
        Chambre ch3Log3 = new Chambre(log3, 14);
        ch3Log3 = chambreRepository.save(ch3Log3);
        Chambre ch4Log3 = new Chambre(log3, 13);
        ch4Log3 = chambreRepository.save(ch4Log3);
        Chambre ch1Log4 = new Chambre(log4, 12);
        ch1Log4 = chambreRepository.save(ch1Log4);
        Chambre ch2Log4 = new Chambre(log4, 16);
        ch2Log4 = chambreRepository.save(ch2Log4);

        //Creation des Message
        Message message1Loc1Proprio1 = new Message(locataire1, proprio1, "Premier message loc1 vers proprio1");
        message1Loc1Proprio1 = messageRepository.save(message1Loc1Proprio1);
        Message message1Proprio1Loc1 = new Message(proprio1, locataire1, "Premier message proprio1 vers loc1");
        message1Proprio1Loc1 = messageRepository.save(message1Proprio1Loc1);
        Message message2Loc1Proprio1 = new Message(locataire1, proprio1, "Premier message loc1 vers proprio1");
        message2Loc1Proprio1 = messageRepository.save(message2Loc1Proprio1);
        Message message1Loc3Proprio2 = new Message(locataire3, proprio2, "Premier message loc3 vers proprio2");
        message1Loc3Proprio2 = messageRepository.save(message1Loc3Proprio2);
        Message message1Proprio2Loc3 = new Message(proprio2, locataire3, "Premier message proprio2 vers loc3");
        message1Proprio2Loc3 = messageRepository.save(message1Proprio2Loc3);
        Message message1Loc7Proprio4 = new Message(locataire7, proprio4, "Premier message loc7 vers proprio4");
        message1Loc7Proprio4 = messageRepository.save(message1Loc7Proprio4);

        // Creation des Dossier
        Dossier dossierLoc1 = new Dossier(1500.0, 2200.0, Situation.Salarie);
        locataire1.setDossier(dossierLoc1);
        locataire1 = locataireRepository.save(locataire1);
        Dossier dossierLoc4 = new Dossier(0.0, 2500.0, Situation.Salarie);
        locataire4.setDossier(dossierLoc4);
        locataire4 = locataireRepository.save(locataire4);
        Dossier dossierLoc5 = new Dossier(800.0, 1600.0, Situation.Salarie);
        locataire5.setDossier(dossierLoc5);
        locataire5 = locataireRepository.save(locataire5);
        
        // Ajout de Commodite a Logement
        log1.addCommodite(jardin);
        log1 = logementRepository.save(log1);

        // Fonctionne jusque là 

        spring.close();
    }
}
