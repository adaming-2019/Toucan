package fr.adaming.dao;

import fr.adaming.entities.CategorieVehicule;
import fr.adaming.entities.Client;

public class CatVehiculeDaoImpl extends GenericDaoImpl<CategorieVehicule> implements ICatVehiculeDao {

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Client
	public CatVehiculeDaoImpl() {
		clazz = CategorieVehicule.class;

	}

}
