package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Continent;
import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

@Repository
public class DestinationDaoImpl extends GenericDaoImpl<Destination> implements IDestinationDao {

	// injection de la session factory
	private SessionFactory sf;

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est
	// Prestation
	public DestinationDaoImpl() {
		clazz = Destination.class;
	}

	@Override
	public Destination getDestinationByContinent(Continent continentIn) {
		// récupérer la session
		Session s = sf.getCurrentSession();

		// création de la requete HQL
		String req = "FROM Destination d WHERE d.continent=:pContinent ";

		// création du query de hb
		Query query = s.createQuery(req);

		// passage des valeurs aux params
		query.setParameter("pContinent", continentIn.getDeclaringClass());

		// envoie de la requete et récupérer le résultat
		List<Destination> listeDestinations = query.list();

		return (Destination) listeDestinations;
	}

}
