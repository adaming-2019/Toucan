package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Voyage;

@Repository
public class VoyageDaoImpl extends GenericDaoImpl<Voyage> implements IVoyageDao {

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Voyage
	public VoyageDaoImpl() {
		clazz = Voyage.class;
	}
	
	

}
