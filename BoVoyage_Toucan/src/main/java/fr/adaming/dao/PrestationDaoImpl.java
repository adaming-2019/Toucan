package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Prestation;


@Repository
public class PrestationDaoImpl extends GenericDaoImpl<Prestation> implements IPrestationDao{
	
	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Prestation 
	public PrestationDaoImpl() {
		clazz=Prestation.class;
		
	}

}
