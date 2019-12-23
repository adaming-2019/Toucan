package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Assurance;

public interface IAssuranceService {

	// les méthodes pour assurance
	public List<Assurance> getAllAssurances();

	public Assurance getById(int id);

	public Assurance addAssurance(Assurance assuranceIn);

	public Assurance update(Assurance assuranceIn);

	public boolean deleteAssurance(int id);
	
	public Assurance getAssuranceByType(String type);

}
