package fr.adaming.entities;

public class Destination {

	// declaration des attributs
	private int id;
	private String continent;
	private String pays;

	// declaration des constructeurs
	public Destination() {
		super();
	}

	public Destination(String continent, String pays) {
		super();
		this.continent = continent;
		this.pays = pays;
	}

	public Destination(int id, String continent, String pays) {
		super();
		this.id = id;
		this.continent = continent;
		this.pays = pays;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// declarations getters et setters
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", continent=" + continent + ", pays=" + pays + "]";
	}

	
	
	
}
