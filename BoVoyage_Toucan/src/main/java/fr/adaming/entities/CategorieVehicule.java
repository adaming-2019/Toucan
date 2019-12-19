package fr.adaming.entities;

public class CategorieVehicule {

	//Déclaration de l'énumération CategorieVehicule
	private int id;
	CategorieVehicules categorieVehicule;

	
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

	@Override
	public String toString() {
		return "CategorieVehicule [id=" + id + ", categorieVehicule=" + categorieVehicule + "]";
	}
	
	
}
