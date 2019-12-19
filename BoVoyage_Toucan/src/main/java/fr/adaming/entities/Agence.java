package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agences")
public class Agence implements Serializable{

	// declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ag")
	private int id;
	
	@Column(name="nom_ag")
	private String nom;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="agence")
	private List<Voyage> voyages;

	//declaration des constructeurs
	public Agence() {
		super();
	}

	public Agence(String nom) {
		super();
		this.nom = nom;
	}

	public Agence(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	//declaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + "]";
	}
	

	
	
	
	

}
