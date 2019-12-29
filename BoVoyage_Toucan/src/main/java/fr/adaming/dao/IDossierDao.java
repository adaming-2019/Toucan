package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;

public interface IDossierDao extends IGenericDao<Dossier>{
	
	public List<Dossier> getAllByClient(Client clIn);

}
