package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Enumerated(EnumType.STRING) //rajout au 30/12
	Prestations prestation;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="prestation")
	private List<Voyage> voyages;
	
	//declaration des constructeurs
	public Prestation() {
		super();
	}

	public Prestation(Prestations prestation) {
		super();
		this.prestation = prestation;
	}

	public Prestation(int id, Prestations prestation) {
		super();
		this.id = id;
		this.prestation = prestation;
	}


	//declaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prestations getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestations prestation) {
		this.prestation = prestation;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", prestation=" + prestation + "]";
	}
	
	
	
	
	
	
	

}
