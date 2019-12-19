package fr.adaming.dao;

import fr.adaming.entities.CategorieVehicule;
import fr.adaming.entities.LoueurVehicule;

public class LoueurVehiculeDaoImpl extends GenericDaoImpl<LoueurVehicule> implements ILoueurVehiculeDao {

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Client
	public LoueurVehiculeDaoImpl() {
		clazz = LoueurVehicule.class;

	}

}
