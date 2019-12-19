package fr.adaming.entities;

public class Formule {

	//déclaration des attributs 
	public String id;
	Formules formule;
	
	//déclaration du constructeur vide
	public Formule() {
		super();
	}

	//déclaration des constructeurs avec paramètres
	public Formule(Formules formule) {
		super();
		this.formule = formule;
	}

	public Formule(String id, Formules formule) {
		super();
		this.id = id;
		this.formule = formule;
	}

	//déclaration des getters et setters 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Formules getFormule() {
		return formule;
	}

	public void setFormule(Formules formule) {
		this.formule = formule;
	}

	//redéfinition de ToString
	@Override
	public String toString() {
		return "Formule [id=" + id + ", formule=" + formule + "]";
	}
	

	
}
