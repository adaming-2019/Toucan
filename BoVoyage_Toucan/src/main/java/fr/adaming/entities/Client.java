package fr.adaming.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client extends Personne {

	// Declaration des attributs
	@Column(name="cb_cl")
	private int cb;
	
	@Column(name="login_cl")
	private String login;
	
	@Column(name="mdp_cl")
	private String mdp;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="client")
	private List<Dossier> dossiers;

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

	public List<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}

	@Override
	public String toString() {
		return "Client [cb=" + cb + ", login=" + login + ", mdp=" + mdp + ", id=" + id + ", civilite=" + civilite
				+ ", nom=" + nom + ", prenom=" + prenom + ", dn=" + dn + ", adresse=" + adresse + ", telephone="
				+ telephone + ", nationalite=" + nationalite + "]";
	}

}
