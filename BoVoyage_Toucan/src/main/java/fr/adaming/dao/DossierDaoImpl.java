package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;

@Repository
public class DossierDaoImpl extends GenericDaoImpl<Dossier> implements IDossierDao{

	//Sp�cifier le vrai type de T, ici c'est Dossier
	public DossierDaoImpl() {
		clazz=Dossier.class;
	}

	@Override
	public List<Dossier> getAllByClient(Client clIn) {
		// r�cup�rer la session hibernate
		Session s = sf.getCurrentSession();
		
		// �crire la requ�te hql
		String req = "FROM Dossier d WHERE d.client =:pClient";
		
		// cr�er un Query
		Query query = s.createQuery(req);
		
		// passage des valeurs aux params de la requete
		query.setParameter("pClient", clIn);
		
		// envoi de la requ�te et r�cup�ration du r�sultat
		List<Dossier> listeOut = query.list();
		
		return listeOut;
	}
	
	
}
