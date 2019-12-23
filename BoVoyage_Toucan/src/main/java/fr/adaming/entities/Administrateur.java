package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="administrateurs")
public class Administrateur implements Serializable {

	// declaration attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ad")
	private int id;
	@Column(name="login_ad")
	private String login;
	@Column(name="mdp_ad")
	private String mdp;
	@Column(name="active_ad")
	private boolean active;
	
	// transformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name="ro_id", referencedColumnName="id_ro")
	private Role role;

	// declaration des constructeurs
	public Administrateur() {
		super();
	}

	public Administrateur(String login, String mdp, boolean active) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.active = active;
	}

	public Administrateur(int id, String login, String mdp, boolean active) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.active = active;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Administrateur [id=" + id + ", login=" + login + ", mdp=" + mdp + ", active=" + active + "]";
	}

	

}
