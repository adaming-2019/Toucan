package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Assurance;

@Repository
public class AssuranceDaoImpl extends GenericDaoImpl<Assurance> implements IAssuranceDao {

	//Spécifier le vrai type de T, ici c'est Assurance
	public AssuranceDaoImpl() {
		clazz = Assurance.class;
	}

}
