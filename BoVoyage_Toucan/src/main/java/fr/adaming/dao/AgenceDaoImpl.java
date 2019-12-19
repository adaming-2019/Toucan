package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Agence;

@Repository
public class AgenceDaoImpl extends GenericDaoImpl<Agence> implements IAgenceDao {

	//Spécifier le vrai type de T, ici c'est Agence
	public AgenceDaoImpl() {
		clazz = Agence.class;
	}

}
