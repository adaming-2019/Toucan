package fr.adaming.entities;

public class LoueurVehicule {

	//déclaration des attributs 
	private int id;
	LoueurVehicules loueurVéhicule;
	
	//définition du constructeur vide
	public LoueurVehicule() {
		super();
	}

	//définition du constructeur avec paramètres
	public LoueurVehicule(int id, LoueurVehicules loueurVéhicule) {
		super();
		this.id = id;
		this.loueurVéhicule = loueurVéhicule;
	}

	public LoueurVehicule(LoueurVehicules loueurVéhicule) {
		super();
		this.loueurVéhicule = loueurVéhicule;
	}

	
	//définition des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoueurVehicules getLoueurVéhicule() {
		return loueurVéhicule;
	}

	public void setLoueurVéhicule(LoueurVehicules loueurVéhicule) {
		this.loueurVéhicule = loueurVéhicule;
	}

	//redéfintion de toString 
	@Override
	public String toString() {
		return "LoueurVehicule [id=" + id + ", loueurVéhicule=" + loueurVéhicule + "]";
	}
	
	  
}
