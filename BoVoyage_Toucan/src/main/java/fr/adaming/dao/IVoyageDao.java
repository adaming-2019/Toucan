package fr.adaming.dao;

import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

public interface IVoyageDao extends IGenericDao<Voyage> {
	
	public Voyage getVoyageByDestination (Destination destinationIn);

}
