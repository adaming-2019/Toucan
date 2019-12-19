package fr.adaming.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loueursvehicules")
public class LoueurVehicule {

	//déclaration des attributs 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lv")
	private int id;
	
	@Column(name="loueurVehicule_lv")
	LoueurVehicules loueurVehicule;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="loueurVehicule")
	private List<Voyage> voyages;
	
	//définition du constructeur vide
	public LoueurVehicule() {
		super();
	}

	//définition du constructeur avec paramètres
	public LoueurVehicule(int id, LoueurVehicules loueurVehicule) {
		super();
		this.id = id;
		this.loueurVehicule = loueurVehicule;
	}

	public LoueurVehicule(LoueurVehicules loueurVehicule) {
		super();
		this.loueurVehicule = loueurVehicule;
	}

	
	//définition des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoueurVehicules getLoueurVehicule() {
		return loueurVehicule;
	}

	public void setLoueurVéhicule(LoueurVehicules loueurVehicule) {
		this.loueurVehicule = loueurVehicule;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	//redéfintion de toString 
	@Override
	public String toString() {
		return "LoueurVehicule [id=" + id + ", loueurVehicule=" + loueurVehicule + "]";
	}
	
	  
}
