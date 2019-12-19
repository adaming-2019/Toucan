package fr.adaming.entities;

public class LoueurVehicule {

	//d�claration des attributs 
	private int id;
	LoueurVehicules loueurV�hicule;
	
	//d�finition du constructeur vide
	public LoueurVehicule() {
		super();
	}

	//d�finition du constructeur avec param�tres
	public LoueurVehicule(int id, LoueurVehicules loueurV�hicule) {
		super();
		this.id = id;
		this.loueurV�hicule = loueurV�hicule;
	}

	public LoueurVehicule(LoueurVehicules loueurV�hicule) {
		super();
		this.loueurV�hicule = loueurV�hicule;
	}

	
	//d�finition des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoueurVehicules getLoueurV�hicule() {
		return loueurV�hicule;
	}

	public void setLoueurV�hicule(LoueurVehicules loueurV�hicule) {
		this.loueurV�hicule = loueurV�hicule;
	}

	//red�fintion de toString 
	@Override
	public String toString() {
		return "LoueurVehicule [id=" + id + ", loueurV�hicule=" + loueurV�hicule + "]";
	}
	
	  
}
