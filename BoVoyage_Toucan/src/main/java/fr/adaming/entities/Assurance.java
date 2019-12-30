package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="assurances")
public class Assurance implements Serializable {
	
	// déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_as")
	private int id;
	
	@Column(name="type_as")
	private String type;
	
	@Column(name="montant_as")
	private double montant;
	
	// transformation de l'association UML en Java
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="dossiersassurances", joinColumns=@JoinColumn(name="as_id"), inverseJoinColumns=@JoinColumn(name="do_id"))
	private Set<Dossier> dossiers;
	
	// déclaration des constructeurs
	public Assurance() {
		super();
	}
	public Assurance(String type, double montant) {
		super();
		this.type = type;
		this.montant = montant;
	}
	public Assurance(int id, String type, double montant) {
		super();
		this.id = id;
		this.type = type;
		this.montant = montant;
	}
	
	// déclaration des getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public Set<Dossier> getDossiers() {
		return dossiers;
	}
	public void setDossiers(Set<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
	// redéfinition de la méthode toString
	@Override
	public String toString() {
		return "Assurance [id=" + id + ", type=" + type + ", montant=" + montant + "]";
	}
	
	

}
