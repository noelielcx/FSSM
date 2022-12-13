/**
 * @(#) Club.java
 */
package FFSSM;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    public Plongee plongee;
    public HashSet<Plongee> lesPlongeesNonConformes = new HashSet<>();
    public ArrayList<Plongee> lesPlongeesOrganisees = new ArrayList<>();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        //throw new UnsupportedOperationException("Pas encore implémenté");
        this.lesPlongeesOrganisees.forEach((p) ->{
            if (!p.estConforme()){
                this.lesPlongeesNonConformes.add(p);
            }
        });
        return this.lesPlongeesNonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        //throw new UnsupportedOperationException("Pas encore implémenté");
        this.lesPlongeesOrganisees.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
