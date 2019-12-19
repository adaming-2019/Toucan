package fr.adaming.entities;

public class CategorieVehicule {

	//D�claration de l'�num�ration CategorieVehicule
	private int id;
	CategorieVehicules categorieVehicule;

	
	//d�claration des constructeurs
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

	//d�finition des getters et setters
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
