package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

@Repository
public class VoyageDaoImpl extends GenericDaoImpl<Voyage> implements IVoyageDao {

	// injection de la session factory
	private SessionFactory sf;

	// specifier le vrai type de T (la vraie Entity � utiliser ) ici c'est Voyage
	public VoyageDaoImpl() {
		clazz = Voyage.class;
	}

	@Override
	public Voyage getVoyageByDestination(Destination destinationIn) {
		// r�cup�rer la session
		Session s = sf.getCurrentSession();

		// cr�ation de la requete HQL
		String req = "FROM Voyage v, Destination d WHERE v.destination.id=d.id AND d.continent=:pContinent ";

		// cr�ation du query de hb
		Query query = s.createQuery(req);
		
		// passage des valeurs aux params
		query.setParameter("pContinent", destinationIn.getContinent());
		
		// envoie de la requete et r�cup�rer le r�sultat
		List<Destination> listeDestinations=query.list();
		
		return (Voyage) listeDestinations;
	}

}
