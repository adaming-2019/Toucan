package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Continent;
import fr.adaming.entities.Voyage;

@Repository
public class VoyageDaoImpl extends GenericDaoImpl<Voyage> implements IVoyageDao {

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Voyage
	public VoyageDaoImpl() {
		clazz = Voyage.class;
	}

	@Override
	public List<Voyage> getVoyageByDestination (Continent continentIn) {
		// récupérer la session
		Session s = sf.getCurrentSession();

		// création de la requete HQL
		
		String req = "FROM Voyage v WHERE v.destination.continent=:pContinent";

		// création du query de hb
		Query query = s.createQuery(req);
		
		// passage de params
		query.setParameter("pContinent", continentIn);

		// envoie de la requete et récupérer le résultat
		List<Voyage> listeVoyages = query.list();

		return listeVoyages;
	}

}
