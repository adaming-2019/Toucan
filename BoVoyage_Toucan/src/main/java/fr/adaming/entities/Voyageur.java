package fr.adaming.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="voyageurs")
public class Voyageur extends Personne {

	// Declaration des attributs
	@Column(name="numSiege_vr")
	private String numSiege;
	
	// transformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name="do_id", referencedColumnName="id_do")
	private Dossier dossier;

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

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	// Methode toString
	@Override
	public String toString() {
		return "Voyageur [numSiege=" + numSiege + ", id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom="
				+ prenom + ", dn=" + dn + ", adresse=" + adresse + ", telephone=" + telephone + ", nationalite="
				+ nationalite + "]";
	}

}
