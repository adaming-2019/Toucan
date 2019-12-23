package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Assurance;

@Repository
public class AssuranceDaoImpl extends GenericDaoImpl<Assurance> implements IAssuranceDao {

	//Sp�cifier le vrai type de T, ici c'est Assurance
	public AssuranceDaoImpl() {
		clazz = Assurance.class;
	}

	@Override
	public Assurance getAssuranceByType(String type) {
		// R�cup�rer la session hibernate
		Session s = sf.getCurrentSession();
		
		// �criture de la requ�te hql
		String req = "FROM Assurance a WHERE a.type=:pType";
		
		// cr�er un Query
		Query query = s.createQuery(req);
		
		// passage des valeurs aux params de la requ�te
		query.setParameter("pType", type);
		
		// envoi de la requ�te et r�cup�ration du r�sultat
		Assurance assuranceOut = (Assurance) query.uniqueResult();
		
		return assuranceOut;
	}

}
