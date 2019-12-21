package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Agence;

public interface IAgenceService {

	// les méthodes pour assurance
	public List<Agence> getAllAgence();

	public Agence getById(int id);

	public Agence addAgence(Agence agenceIn);

	public Agence update(Agence agenceIn);

	public boolean deleteAgence(int id);
}
