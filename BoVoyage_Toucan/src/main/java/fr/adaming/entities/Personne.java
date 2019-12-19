package fr.adaming.entities;

import java.util.Date;

public abstract class Personne {

	// Declaration des attributs
	protected int id;
	protected String civilite;
	protected String nom;
	protected String prenom;
	protected Date dn;
	protected String adresse;
	protected String telephone;
	protected String nationalite;

	// Declaration des constructeurs
	public Personne() {
		super();
	}

	public Personne(String civilite, String nom, String prenom, Date dn, String adresse, String telephone,
			String nationalite) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
		this.telephone = telephone;
		this.nationalite = nationalite;
	}

	public Personne(int id, String civilite, String nom, String prenom, Date dn, String adresse, String telephone,
			String nationalite) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
		this.telephone = telephone;
		this.nationalite = nationalite;
	}

	// Declaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDn() {
		return dn;
	}

	public void setDn(Date dn) {
		this.dn = dn;
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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	// Methode toString
	@Override
	public String toString() {
		return "Personne [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", dn=" + dn
				+ ", adresse=" + adresse + ", telephone=" + telephone + ", nationalite=" + nationalite + "]";
	}

}
