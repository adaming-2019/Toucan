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
@Table(name="prestations")
public class Prestation implements Serializable{
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private int id;
	
	@Column(name="intitule_p")
	private String intitule;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="prestation")
	private List<Voyage> voyages;
	
	//declaration des constructeurs
	public Prestation() {
		super();
	}

	public Prestation(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Prestation(int id, String intitule) {
		super();
		this.id = id;
		this.intitule = intitule;
	}


	//declaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", intitule=" + intitule + "]";
	}
	
	
	
	
	
	
	

}
