package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Formule;


@Repository
public class FormuleDaoImpl extends GenericDaoImpl<Formule> implements IFormuleDao{

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Prestation 
	public FormuleDaoImpl() {
		clazz=Formule.class;
	}
}
