package fr.adaming.dao;

import fr.adaming.entities.Assurance;

public interface IAssuranceDao extends IGenericDao<Assurance> {
	
	public Assurance getAssuranceByType(String type);

}
