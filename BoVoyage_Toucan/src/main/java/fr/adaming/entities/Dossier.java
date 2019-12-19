package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

public class Dossier implements Serializable {
	
	// déclaration des attributs
	private int id;
	private String etat;
	
	// transformation de l'association UML en Java
	private List<Assurance> assurances;
	
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
	
	// redéfinition de la méthode toString
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", etat=" + etat + "]";
	}
	
	

}
