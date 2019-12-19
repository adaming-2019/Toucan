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
@Table(name="categoriesvehicules")
public class CategorieVehicule {

	//Déclaration de l'énumération CategorieVehicule
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cv")
	private int id;
	
	@Column(name="categorievehicule_cv")
	CategorieVehicules categorieVehicule;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="categorieVehicule")
	private List<Voyage> voyages;

	
	//déclaration des constructeurs
	public CategorieVehicule() {
		super();
	}

	public CategorieVehicule(CategorieVehicules categorieVehicule) {
		super();
		this.categorieVehicule = categorieVehicule;
	}

	
	public CategorieVehicule(int id, CategorieVehicules categorieVehicule) {
		super();
		this.id = id;
		this.categorieVehicule = categorieVehicule;
	}

	//définition des getters et setters
	public CategorieVehicules getCategorieVehicule() {
		return categorieVehicule;
	}

	public void setCategorieVehicule(CategorieVehicules categorieVehicule) {
		this.categorieVehicule = categorieVehicule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	@Override
	public String toString() {
		return "CategorieVehicule [id=" + id + ", categorieVehicule=" + categorieVehicule + "]";
	}
	
	
}
