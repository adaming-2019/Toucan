package fr.adaming.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="voyages")
public class Voyage implements Serializable {

	// Declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_v")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateRetour;
	private int nombrePlace;
	private double prixAgence;
	private double prixBoVoyage;
	private boolean statut;
	private byte[] photos;
	
	
	// Transformations des associations UML en JAVA
	// ... plus tard ...
	
	// Constructeurs
	// constructeur vide
	public Voyage() {
		super();
	}

	// constructeur avec id
	public Voyage(int id) {
		super();
		this.id = id;
	}

	// constructeur complet sans id
	public Voyage(Date dateDebut, Date dateRetour, int nombrePlace, double prixAgence, double prixBoVoyage, boolean statut, byte[] photos) {
		super();
		this.dateDebut = dateDebut;
		this.dateRetour = dateRetour;
		this.nombrePlace = nombrePlace;
		this.prixAgence = prixAgence;
		this.prixBoVoyage = prixBoVoyage;
		this.statut = statut;
		this.photos = photos;
	}
	
	// constructeur complet sans id
	public Voyage(int id, Date dateDebut, Date dateRetour, int nombrePlace, double prixAgence, double prixBoVoyage, boolean statut, byte[] photos) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateRetour = dateRetour;
		this.nombrePlace = nombrePlace;
		this.prixAgence = prixAgence;
		this.prixBoVoyage = prixBoVoyage;
		this.statut = statut;
		this.photos = photos;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public double getPrixAgence() {
		return prixAgence;
	}

	public void setPrixAgence(double prixAgence) {
		this.prixAgence = prixAgence;
	}

	public double getPrixBoVoyage() {
		return prixBoVoyage;
	}

	public void setPrixBoVoyage(double prixBoVoyage) {
		this.prixBoVoyage = prixBoVoyage;
	}

	public boolean getStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public byte[] getPhotos() {
		return photos;
	}

	public void setPhotos(byte[] photos) {
		this.photos = photos;
	}

	// methodes metiers
	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateDebut=" + dateDebut + ", dateRetour=" + dateRetour + ", nombrePlace="
				+ nombrePlace + ", prixAgence=" + prixAgence + ", prixBoVoyage=" + prixBoVoyage + ", statut=" + statut
				+ ", photos=" + Arrays.toString(photos) + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
