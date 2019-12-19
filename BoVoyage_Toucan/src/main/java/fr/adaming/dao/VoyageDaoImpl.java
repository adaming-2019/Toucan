package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Voyage;

@Repository
public class VoyageDaoImpl implements IVoyageDao{

	private SessionFactory sf;

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}	
	
	// methodes
	@Override
	public List<Voyage> getAllVoyages() {
		// récupérer la session
		Session s = sf.getCurrentSession();

		// écrire la requête hql
		String req = "FROM Voyage v";

		// créer un Query
		Query query = s.createQuery(req);

		// envoi de la requête et récupération du résultat
		List<Voyage> listeOut = query.list();

		return listeOut;
	}

	@Override
	public Voyage getVoyageById(Voyage vIn) {
		// récupérer la session en cours
		Session s = sf.getCurrentSession();

		// La méthode de la session pour récupérer un voyage by id
		Voyage vOut=(Voyage) s.get(Voyage.class, vIn.getId());
		
		return vOut;
	}

	@Override
	public Voyage addVoyage(Voyage vIn) {
		//récupérer la session 
		Session s=sf.getCurrentSession();
		
		//ajouter un voyage
		s.save(vIn);	
	
		return vIn;
	}

	@Override
	public void deleteVoyage(Voyage vIn) {
		// recupere la session
		Session s = sf.getCurrentSession();
		
		//Supprime le voyage
		s.delete(vIn);
	}

	@Override
	public void updateVoyage(Voyage vIn) {
		// recuperer la session
		Session s= sf.getCurrentSession();
		
		// modifier le voyage
		s.saveOrUpdate(vIn);	
	}

}
