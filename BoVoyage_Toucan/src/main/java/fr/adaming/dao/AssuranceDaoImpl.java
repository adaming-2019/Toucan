package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Assurance;

@Repository
public class AssuranceDaoImpl extends GenericDaoImpl<Assurance> implements IAssuranceDao {

	//Spécifier le vrai type de T, ici c'est Assurance
	public AssuranceDaoImpl() {
		clazz = Assurance.class;
	}

	@Override
	public Assurance getAssuranceByType(String type) {
		// Récupérer la session hibernate
		Session s = sf.getCurrentSession();
		
		// écriture de la requête hql
		String req = "FROM Assurance a WHERE a.type=:pType";
		
		// créer un Query
		Query query = s.createQuery(req);
		
		// passage des valeurs aux params de la requête
		query.setParameter("pType", type);
		
		// envoi de la requête et récupération du résultat
		Assurance assuranceOut = (Assurance) query.uniqueResult();
		
		return assuranceOut;
	}

}
