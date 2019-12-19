package fr.adaming.entities;

import java.util.Date;

public class Voyageur extends Personne {

	// Declaration des attributs
	private String numSiege;

	// Declaration des constructeurs
	public Voyageur() {
		super();
	}

	public Voyageur(String civilite, String nom, String prenom, Date dn, String adresse, String telephone,
			String nationalite, String numSiege) {
		super(civilite, nom, prenom, dn, adresse, telephone, nationalite);
		this.numSiege = numSiege;
	}

	public Voyageur(int id, String civilite, String nom, String prenom, Date dn, String adresse, String telephone,
			String nationalite, String numSiege) {
		super(id, civilite, nom, prenom, dn, adresse, telephone, nationalite);
		this.numSiege = numSiege;
	}

	// Decalartion des getters et setters
	public String getNumSiege() {
		return numSiege;
	}

	public void setNumSiege(String numSiege) {
		this.numSiege = numSiege;
	}

	// Methode toString
	@Override
	public String toString() {
		return "Voyageur [numSiege=" + numSiege + ", id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom="
				+ prenom + ", dn=" + dn + ", adresse=" + adresse + ", telephone=" + telephone + ", nationalite="
				+ nationalite + "]";
	}

}
