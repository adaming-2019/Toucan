package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.CategorieVehicule;

public interface ICatVehiculeService {

	// les methode generic
	public List<CategorieVehicule> getAll();

	public CategorieVehicule getById(int id);

	public CategorieVehicule add(CategorieVehicule cv);

	public CategorieVehicule update(CategorieVehicule cv);

	public boolean delete(int id);

}
