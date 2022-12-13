/**
 * @(#) Moniteur.java
 */
package FFSSM;
import java.util.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public Embauche embauche;
    public ArrayList<Embauche> lesEmbauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
        this.lesEmbauches = new ArrayList<Embauche>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() throws Exception {
       if(this.lesEmbauches.size() == 0) return Optional.ofNullable(null);
       lesEmbauches.sort((o1, o2) -> o1.getDebut().compareTo(o2.getDebut()));
       return Optional.ofNullable(lesEmbauches.get(lesEmbauches.size()-1).getEmployeur());
    }


    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        Embauche embauche = new Embauche(debutNouvelle, this, employeur);
        this.lesEmbauches.add(embauche);
        this.embauche = embauche;
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        return this.lesEmbauches;
    }

}
