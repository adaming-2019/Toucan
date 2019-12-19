package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

public class Assurance implements Serializable {
	
	// d�claration des attributs
	private int id;
	private String type;
	private double montant;
	
	// transformation de l'association UML en Java
	private List<Dossier> dossiers;
	
	// d�claration des constructeurs
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
	
	// d�claration des getters et setters
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
	
	// red�finition de la m�thode toString
	@Override
	public String toString() {
		return "Assurance [id=" + id + ", type=" + type + ", montant=" + montant + "]";
	}
	
	

}
