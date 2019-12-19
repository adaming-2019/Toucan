package fr.adaming.entities;

import javax.persistence.Entity;


public class Prestation {
	
	//declaration des attributs
	private int id;
	private String intitule;
	
	//declaration des constructeurs
	public Prestation() {
		super();
	}

	public Prestation(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Prestation(int id, String intitule) {
		super();
		this.id = id;
		this.intitule = intitule;
	}


	//declaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", intitule=" + intitule + "]";
	}
	
	
	
	
	
	
	

}
