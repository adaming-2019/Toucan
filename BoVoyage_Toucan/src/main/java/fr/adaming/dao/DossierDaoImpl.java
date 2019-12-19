package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Dossier;

@Repository
public class DossierDaoImpl extends GenericDaoImpl<Dossier> implements IDossierDao{

	//Spécifier le vrai type de T, ici c'est Dossier
	public DossierDaoImpl() {
		clazz=Dossier.class;
	}
	
	
}
