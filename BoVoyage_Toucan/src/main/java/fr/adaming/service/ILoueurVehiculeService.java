package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.LoueurVehicule;

public interface ILoueurVehiculeService {

	// les methode generic
	public List<LoueurVehicule> getAll();

	public LoueurVehicule getById(int id);

	public LoueurVehicule add(LoueurVehicule cv);

	public LoueurVehicule update(LoueurVehicule cv);

	public boolean delete(int id);

}
