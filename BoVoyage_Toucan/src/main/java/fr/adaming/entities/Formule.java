package fr.adaming.entities;

public class Formule {

	//d�claration des attributs 
	public String id;
	Formules formule;
	
	//d�claration du constructeur vide
	public Formule() {
		super();
	}

	//d�claration des constructeurs avec param�tres
	public Formule(Formules formule) {
		super();
		this.formule = formule;
	}

	public Formule(String id, Formules formule) {
		super();
		this.id = id;
		this.formule = formule;
	}

	//d�claration des getters et setters 
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

	//red�finition de ToString
	@Override
	public String toString() {
		return "Formule [id=" + id + ", formule=" + formule + "]";
	}
	

	
}
