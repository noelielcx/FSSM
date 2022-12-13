package FFSSM;
import jdk.internal.icu.text.UnicodeSet;

import java.util.*;
import java.time.LocalDate;
public class Plongeur extends Personne {

    private int niveau;
    ArrayList <Licence> listeLicence = new ArrayList<Licence>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;

    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau() {
        this.niveau = niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        Licence l = new Licence(this, numero, delivrance, niveau, club);
        listeLicence.add(l);

    }

}