package fr.adaming.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name="active_cl")
	private boolean active;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL)
	private List<Dossier> dossiers;
	
	@ManyToOne
	@JoinColumn(name="ro_id", referencedColumnName="id_ro")
	private Role role;

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
		this.active = true;
	}

	public Client(int id, String civilite, String nom, String prenom, Date dn, String adresse, String telephone,
			String nationalite, int cb, String login, String mdp) {
		super(id, civilite, nom, prenom, dn, adresse, telephone, nationalite);
		this.cb = cb;
		this.login = login;
		this.mdp = mdp;
		this.active = true;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Client [cb=" + cb + ", login=" + login + ", mdp=" + mdp + ", active=" + active + ", id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", dn="
				+ dn + ", adresse=" + adresse + ", telephone=" + telephone + ", nationalite=" + nationalite + "]";
	}
	
	

}
