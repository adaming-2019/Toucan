package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

public interface IVoyageService {

	public List<Voyage> getAllVoyages();
	
	public Voyage getVoyageById(Voyage eIn);
	
	public Voyage addVoyage(Voyage eIn);
	
	public boolean deleteVoyage(Voyage eIn);
	
	public boolean updateVoyage(Voyage eIn);
	
	public Voyage getVoyageByDestination (Destination destinationIn);
	
}
