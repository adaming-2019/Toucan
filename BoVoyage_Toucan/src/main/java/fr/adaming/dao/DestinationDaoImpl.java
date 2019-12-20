package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Destination;


@Repository
public class DestinationDaoImpl extends GenericDaoImpl<Destination> implements IDestinationDao {

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est
	// Prestation
	public DestinationDaoImpl() {
		clazz=Destination.class;
	}

}
