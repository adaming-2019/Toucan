package fr.adaming.entities;

public class Agence {

	// declaration des attributs
	private int id;
	private String nom;

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

	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + "]";
	}
	

	
	
	
	

}
