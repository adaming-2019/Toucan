package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Voyageur;

@Repository
public class VoyageurDaoImpl extends GenericDaoImpl<Voyageur>implements IVoyageurDao {

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Voyageur
	public VoyageurDaoImpl() {
		clazz=Voyageur.class;
	}
}
