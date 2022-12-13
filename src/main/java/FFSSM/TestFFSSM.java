package FFSSM;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import FFSSM.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFFSSM {
    Club club;
    Licence licence;
    Moniteur moniteur;
    Plongee plongee;
    Plongeur plongeur;
    Site site;

    @BeforeEach
    public void setUp() {
        club = new Club(moniteur, "PopArt", "0606060606");
        licence = new Licence(plongeur, "65345", LocalDate.of(2020, 5, 3), 1, club);
        moniteur = new Moniteur("11652", "Lacroix", "Noëlie", "11 b rue Malpas", "0781744618", LocalDate.of(2002, 2, 7), 521);
        plongee = new Plongee(site, moniteur, LocalDate.of(2020, 11, 30), 10, 2);
        plongeur = new Plongeur("1952", "Lacroix", "Célia", "449 route de Carayac", "0692448132", LocalDate.of(2004, 4, 6));
        site = new Site("Marseille", "Les details");
    }



    @Test
    public void testAjouteLicence(){
        plongeur.ajouteLicence("65345", LocalDate.of(2020, 5, 3), club);
        assertEquals(plongeur.licence.getDelivrance(), LocalDate.of(2020, 5, 3), "La licence n'est pas attribuee");
    }

    @Test
    public void testEstValide() {
        assertTrue(licence.estValide(LocalDate.now()), "La licence n'est plus valide");
    }

    @Test
    public void testNouvelleEmbauche(){
        moniteur.nouvelleEmbauche(club, LocalDate.of(2018,3,26));
        assertTrue(moniteur.emplois().contains(moniteur.embauche));
    }

    @Test
    public void testOrganisePlongee() {
        club.organisePlongee(plongee);
        assertEquals(plongee, club.lesPlongeesOrganisees.get(0), "La plongee n'est pas ajoutee");

    }

    @Test
    public void testEstConforme(){
        plongeur.ajouteLicence("65345", LocalDate.of(2020, 5, 3), club);
        plongee.ajouteParticipant(plongeur);
        assertTrue(plongee.estConforme(),"La plongee n'est pas conforme");
    }

    @Test
    public void testPlongeesNonConformes(){
        plongeur.ajouteLicence("65345", LocalDate.of(2020, 5, 3), club);
        plongee.ajouteParticipant(plongeur);
        club.organisePlongee(plongee);

        assertFalse(club.plongeesNonConformes().contains(plongee), "La plongee n'est pas conforme");

    }


}

