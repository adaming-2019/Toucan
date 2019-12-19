package fr.adaming.entities;

import java.io.Serializable;

public class Administrateur implements Serializable {

	// declaration attributs
	private int id;
	private String login;
	private String mdp;

	// declaration des constructeurs
	public Administrateur() {
		super();
	}

	public Administrateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public Administrateur(int id, String login, String mdp) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}

	// declaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Administrateur [id=" + id + ", login=" + login + ", mdp=" + mdp + "]";
	}

}
