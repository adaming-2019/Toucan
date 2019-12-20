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
@Table(name="formules")
public class Formule {

	//d�claration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_f")
	public int id;
	
	@Column(name="formule_f")
	Formules formule;
	
	// transformation de l'association UML en JAVA
	@OneToMany(mappedBy="formule")
	private List<Voyage> voyages;
	
	//d�claration du constructeur vide
	public Formule() {
		super();
	}

	//d�claration des constructeurs avec param�tres
	public Formule(Formules formule) {
		super();
		this.formule = formule;
	}

	public Formule(int id, Formules formule) {
		super();
		this.id = id;
		this.formule = formule;
	}

	//d�claration des getters et setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Formules getFormule() {
		return formule;
	}

	public void setFormule(Formules formule) {
		this.formule = formule;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	//red�finition de ToString
	@Override
	public String toString() {
		return "Formule [id=" + id + ", formule=" + formule + "]";
	}
	

	
}
