
package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Continent;
import fr.adaming.entities.Destination;



public interface IDestinationService {

	public List<Destination> getAll();

	public Destination getById(int Did);

	public Destination add(Destination dIn);

	public Destination update(Destination dIn);

	public boolean delete(int id);
	
	public Destination getDestinationByContinent (Continent continentIn);

}
