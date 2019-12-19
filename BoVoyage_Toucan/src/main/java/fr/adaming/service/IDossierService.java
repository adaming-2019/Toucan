package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Dossier;

public interface IDossierService {

	// les m�thodes pour assurance
	public List<Dossier> getAllDossier();

	public Dossier getById(int id);

	public Dossier addAssurance(Dossier dossierIn);

	public Dossier update(Dossier dossierIn);

	public void deleteDossier(int id);
	
	
}
