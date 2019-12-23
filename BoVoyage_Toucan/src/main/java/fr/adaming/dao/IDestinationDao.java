package fr.adaming.dao;

import fr.adaming.entities.Continent;
import fr.adaming.entities.Destination;

public interface IDestinationDao extends IGenericDao<Destination> {

	public Destination getDestinationByContinent (Continent continentIn);
	
}
