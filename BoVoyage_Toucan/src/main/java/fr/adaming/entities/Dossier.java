package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "dossiers")
public class Dossier implements Serializable {

	// déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_do")
	private int id;

	@Column(name = "etat_do")
	private String etat;

	@Column(name = "nbplaces_do")
	private int nbPlaces;

	// transformation de l'association UML en Java
	@ManyToMany(mappedBy = "dossiers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Assurance> assurances;

	@OneToMany(mappedBy="dossier", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Voyageur> voyageurs;

	@ManyToOne
	@JoinColumn(name="cl_id", referencedColumnName="id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "vg_id", referencedColumnName = "id_vg")
	private Voyage voyage;

	// déclaration des constructeurs
	public Dossier() {
		super();
	}

	public Dossier(String etat, int nbPlaces) {
		super();
		this.etat = etat;
		this.nbPlaces = nbPlaces;
	}

	public Dossier(int id, String etat, int nbPlaces) {
		super();
		this.id = id;
		this.etat = etat;
		this.nbPlaces = nbPlaces;
	}

	// déclaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Set<Assurance> getAssurances() {
		return assurances;
	}

	public void setAssurances(Set<Assurance> assurances) {
		this.assurances = assurances;
	}

	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	// redéfinition de la méthode toString
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", etat=" + etat + ", nbPlaces=" + nbPlaces + "]";
	}

}
