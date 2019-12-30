package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

@Repository
public class VoyageDaoImpl extends GenericDaoImpl<Voyage> implements IVoyageDao {

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Voyage
	public VoyageDaoImpl() {
		clazz = Voyage.class;
	}

	@Override
	public List<Voyage> getVoyageByDestination (Destination destinationIn) {
		// récupérer la session
		Session s = sf.getCurrentSession();

		// création de la requete HQL
	//	String req = "FROM Voyage v INNER JOIN Destination d ON v.de_id=d.id_de";
		
		String req = "FROM Voyage v, Destination d WHERE v.de_id=d.id_de AND d.continent=pContinent";

		// création du query de hb
		Query query = s.createQuery(req);
		
		// passage de params
		query.setParameter("pContinent", destinationIn.getContinent());

		// envoie de la requete et récupérer le résultat
		List<Voyage> listeVoyages = query.list();

		return listeVoyages;
	}

}
