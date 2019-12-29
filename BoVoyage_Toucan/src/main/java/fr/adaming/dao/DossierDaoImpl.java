package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;

@Repository
public class DossierDaoImpl extends GenericDaoImpl<Dossier> implements IDossierDao{

	//Spécifier le vrai type de T, ici c'est Dossier
	public DossierDaoImpl() {
		clazz=Dossier.class;
	}

	@Override
	public List<Dossier> getAllByClient(Client clIn) {
		// récupérer la session hibernate
		Session s = sf.getCurrentSession();
		
		// écrire la requête hql
		String req = "FROM Dossier d WHERE d.client =:pClient";
		
		// créer un Query
		Query query = s.createQuery(req);
		
		// passage des valeurs aux params de la requete
		query.setParameter("pClient", clIn);
		
		// envoi de la requête et récupération du résultat
		List<Dossier> listeOut = query.list();
		
		return listeOut;
	}
	
	
}
