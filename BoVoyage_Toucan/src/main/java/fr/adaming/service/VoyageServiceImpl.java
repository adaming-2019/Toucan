package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;

@Service
@Transactional
public class VoyageServiceImpl implements IVoyageService{

	// transformation de l'association UML en java
	private IVoyageDao voyageDao;
	
	@Autowired
	public void setVoyageDao(IVoyageDao voyageDao) {
		this.voyageDao = voyageDao;
	}
		
	@Override
	public List<Voyage> getAllVoyages() {
		// appel de la méthode dao
		return voyageDao.getAll();
	}

	@Override
	public Voyage getVoyageById(int id) {
		// appel de la méthode dao
		return voyageDao.getById(id);
	}

	@Override
	public Voyage addVoyage(Voyage voyageIn) {
		//appel de la méthode Dao
		return voyageDao.add(voyageIn);
	}
	
	@Override
	public Voyage updateVoyage(Voyage voyageIn) {
		//appel de la methode Dao
		return voyageDao.update(voyageIn);
	}

	@Override
	public boolean deleteVoyage(int id) {
		voyageDao.delete(id);
		return true;
	}

	@Override
	public List<Voyage> getVoyageByDestination(Destination destinationIn) {
		
		return voyageDao.getVoyageByDestination(destinationIn);
	}



}
