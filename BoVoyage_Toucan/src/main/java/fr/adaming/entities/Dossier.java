package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dossiers")
public class Dossier implements Serializable {
	
	// déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_do")
	private int id;
	
	@Column(name="etat_do")
	private String etat;
	
	// transformation de l'association UML en Java
	@ManyToMany(mappedBy="dossiers")
	private List<Assurance> assurances;
	
	@OneToMany(mappedBy="dossier")
	private List<Voyageur> voyageurs;
	
	@ManyToOne
	@JoinColumn(name="cl_id", referencedColumnName="id_cl")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="vg_id", referencedColumnName="id_vg")
	private Voyage voyage;
	
	// déclaration des constructeurs
	public Dossier() {
		super();
	}
	public Dossier(String etat) {
		super();
		this.etat = etat;
	}
	
	public Dossier(int id, String etat) {
		super();
		this.id = id;
		this.etat = etat;
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
	
	public List<Assurance> getAssurances() {
		return assurances;
	}
	public void setAssurances(List<Assurance> assurances) {
		this.assurances = assurances;
	}
	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}
	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}
	// redéfinition de la méthode toString
	@Override
	public String toString() {
		return "Dossier [etat=" + etat + "]";
	}
	
	

}
