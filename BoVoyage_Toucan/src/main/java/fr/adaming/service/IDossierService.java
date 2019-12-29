package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Dossier;

public interface IDossierService {

	// les méthodes pour assurance
	public List<Dossier> getAllDossier();

	public Dossier getById(int id);

	public Dossier addDossier(Dossier dossierIn);

	public boolean updateDossier(Dossier dossierIn);

	public boolean deleteDossier(int id);
	
	
}
