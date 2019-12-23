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

	// specifier le vrai type de T (la vraie Entity � utiliser ) ici c'est
	// Prestation
	public DestinationDaoImpl() {
		clazz = Destination.class;
	}

	@Override
	public Destination getDestinationByContinent(Continent continentIn) {
		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// cr�ation de la requete HQL
		String req = "FROM Destination d WHERE d.continent=:pContinent ";

		// cr�ation du query de hb
		Query query = s.createQuery(req);

		// passage des valeurs aux params
		query.setParameter("pContinent", continentIn.getDeclaringClass());

		// envoie de la requete et r�cup�rer le r�sultat
		List<Destination> listeDestinations = query.list();

		return (Destination) listeDestinations;
	}

}
