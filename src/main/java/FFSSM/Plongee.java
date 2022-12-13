/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;
	public ArrayList<Plongeur> lesParticipants = new ArrayList<>();
	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	public void ajouteParticipant(Plongeur participant) {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
		if (!lesParticipants.contains(participant)){
			lesParticipants.add(participant);
		}
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		for (Plongeur p : lesParticipants){
			int nbreLicence = p.listeLicence.size();
			for (int i = nbreLicence-1; i>0; i--){
				if (p.listeLicence.get(i).estValide(this.getDate())){
					break;
				}
			}
			return false;
		}
		return true;
	}

}
