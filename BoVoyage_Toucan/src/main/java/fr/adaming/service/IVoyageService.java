package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

public interface IVoyageService {

	// les méthodes pour voyage
	public List<Voyage> getAllVoyages();
	
	public Voyage getVoyageById(int id);
	
	public Voyage addVoyage(Voyage voyageIn);
	
	public Voyage updateVoyage(Voyage voyageIn);
	
	public boolean deleteVoyage(int id);
	
	public List<Voyage> getVoyageByDestination (Destination destinationIn);
	
	
	
	
}
