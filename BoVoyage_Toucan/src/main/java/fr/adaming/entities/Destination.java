package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="destinations")
public class Destination implements Serializable{

	// declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_de")
	private int id;
	
	@Column(name="continent_de")
	private String continent;
	
	@Column(name="pays_de")
	private String pays;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="destination")
	private List<Voyage> voyages;

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

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", continent=" + continent + ", pays=" + pays + "]";
	}

	
	
	
}
