package fr.adaming.dao;

import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyage;

public interface IClientDao {

	public Voyage addVoyage(Voyage vIn);

	public void deleteVoyage(Voyage vIn);
	
	public void updateVoyage(Voyage vIn);
	
	public Dossier getDossierById(Dossier dIn);
	
	public void updateDossier(Dossier dIn);
	
}
