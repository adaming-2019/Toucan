package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

public interface IVoyageDao extends IGenericDao<Voyage> {
	
	public List<Voyage> getVoyageByDestination (Destination destinationIn);
	
}
