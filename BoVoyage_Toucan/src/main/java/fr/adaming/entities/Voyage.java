package fr.adaming.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name="id_vg")
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(name="dateDebut_vg")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@Column(name="dateRetour_vg")
	private Date dateRetour;
	@Column(name="nombrePlace_vg")
	private int nombrePlace;
	@Column(name="prixAgence_vg")
	private double prixAgence;
	@Column(name="prixBoVoyage_vg")
	private double prixBoVoyage;
	@Column(name="statut_vg")
	private boolean statut;
	@Column(name="photos_vg")
	private byte[] photos;
	//private String photos;
	
	// Transformations des associations UML en JAVA
	@OneToMany(mappedBy="voyage")
	private List<Dossier> dossiers;
	
	@ManyToOne
	@JoinColumn(name="ag_id", referencedColumnName="id_ag")
	private Agence agence;
	
	@ManyToOne
	@JoinColumn(name="lv_id", referencedColumnName="id_lv")
	private LoueurVehicule loueurVehicule;
	
	@ManyToOne
	@JoinColumn(name="cv_id", referencedColumnName="id_cv")
	private CategorieVehicule categorieVehicule;
	
	@ManyToOne
	@JoinColumn(name="f_id", referencedColumnName="id_f")
	private Formule formule;
	
	@ManyToOne
	@JoinColumn(name="de_id", referencedColumnName="id_de")
	private Destination destination;
	
	@ManyToOne
	@JoinColumn(name="p_id", referencedColumnName="id_p")
	private Prestation prestation;
	
	
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
	public Voyage(Date dateDebut, Date dateRetour, int nombrePlace, double prixAgence, double prixBoVoyage,
			boolean statut, byte[] photos, Agence agence, LoueurVehicule loueurVehicule,
			CategorieVehicule categorieVehicule, Formule formule, Destination destination, Prestation prestation) {
		super();
		this.dateDebut = dateDebut;
		this.dateRetour = dateRetour;
		this.nombrePlace = nombrePlace;
		this.prixAgence = prixAgence;
		this.prixBoVoyage = prixBoVoyage;
		this.statut = statut;
		this.photos = photos;
		this.agence = agence;
		this.loueurVehicule = loueurVehicule;
		this.categorieVehicule = categorieVehicule;
		this.formule = formule;
		this.destination = destination;
		this.prestation = prestation;
	}
	
	// constructeur complet avec id
	public Voyage(int id, Date dateDebut, Date dateRetour, int nombrePlace, double prixAgence, double prixBoVoyage,
			boolean statut, byte[] photos, Agence agence, LoueurVehicule loueurVehicule,
			CategorieVehicule categorieVehicule, Formule formule, Destination destination, Prestation prestation) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateRetour = dateRetour;
		this.nombrePlace = nombrePlace;
		this.prixAgence = prixAgence;
		this.prixBoVoyage = prixBoVoyage;
		this.statut = statut;
		this.photos = photos;
		this.agence = agence;
		this.loueurVehicule = loueurVehicule;
		this.categorieVehicule = categorieVehicule;
		this.formule = formule;
		this.destination = destination;
		this.prestation = prestation;
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

	public List<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
	

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public LoueurVehicule getLoueurVehicule() {
		return loueurVehicule;
	}

	public void setLoueurVehicule(LoueurVehicule loueurVehicule) {
		this.loueurVehicule = loueurVehicule;
	}

	public CategorieVehicule getCategorieVehicule() {
		return categorieVehicule;
	}

	public void setCategorieVehicule(CategorieVehicule categorieVehicule) {
		this.categorieVehicule = categorieVehicule;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	// methodes metiers
	/**
	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateDebut=" + dateDebut + ", dateRetour=" + dateRetour + ", nombrePlace="
				+ nombrePlace + ", prixAgence=" + prixAgence + ", prixBoVoyage=" + prixBoVoyage + ", statut=" + statut
				+ ", photos=" + Arrays.toString(photos) + "]";
	}
	**/
	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateDebut=" + dateDebut + ", dateRetour=" + dateRetour + ", nombrePlace="
				+ nombrePlace + ", prixAgence=" + prixAgence + ", prixBoVoyage=" + prixBoVoyage + ", statut=" + statut
				+ ", photos=" + Arrays.toString(photos) + ", agence=" + agence + ", loueurVehicule=" + loueurVehicule
				+ ", categorieVehicule=" + categorieVehicule + ", formule=" + formule + ", destination=" + destination
				+ ", prestation=" + prestation + "]";
	}
	
	
	
	
	
	
	
	
	
}
