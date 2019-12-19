package fr.adaming.entities;

import java.util.Date;

public class Client extends Personne {

	// Declaration des attributs
	private int cb;
	private String login;
	private String mdp;

	// Declaration des constucteurs
	public Client() {
		super();
	}

	public Client(String civilite, String nom, String prenom, Date dn, String adresse, String telephone,
			String nationalite, int cb, String login, String mdp) {
		super(civilite, nom, prenom, dn, adresse, telephone, nationalite);
		this.cb = cb;
		this.login = login;
		this.mdp = mdp;
	}

	public Client(int id, String civilite, String nom, String prenom, Date dn, String adresse, String telephone,
			String nationalite, int cb, String login, String mdp) {
		super(id, civilite, nom, prenom, dn, adresse, telephone, nationalite);
		this.cb = cb;
		this.login = login;
		this.mdp = mdp;
	}

	// Declaration des getters et setters
	public int getCb() {
		return cb;
	}

	public void setCb(int cb) {
		this.cb = cb;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Client [cb=" + cb + ", login=" + login + ", mdp=" + mdp + ", id=" + id + ", civilite=" + civilite
				+ ", nom=" + nom + ", prenom=" + prenom + ", dn=" + dn + ", adresse=" + adresse + ", telephone="
				+ telephone + ", nationalite=" + nationalite + "]";
	}

}
