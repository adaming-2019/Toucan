package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Prestation;

public interface IPrestationService {

	public List<Prestation> getAll();
	
	public Prestation getById(int pId);
	
	public Prestation add(Prestation pId);
	
	public Prestation update(Prestation pId);

	public boolean delete(Prestation id);
	
}
