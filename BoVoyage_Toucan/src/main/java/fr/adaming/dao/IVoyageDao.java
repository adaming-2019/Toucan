package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Voyage;

public interface IVoyageDao {

	public List<Voyage> getAllVoyages();

	public Voyage getVoyageById(Voyage vIn);
	
	public Voyage addVoyage(Voyage vIn);

	public void deleteVoyage(Voyage vIn);
	
	public void updateVoyage(Voyage vIn);
	
}
