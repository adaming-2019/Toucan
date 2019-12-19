package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
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
	public Voyage getVoyageById(Voyage vIn) {
		// appel de la méthode dao
		return voyageDao.getById(vIn.getId());
	}

	@Override
	public Voyage addVoyage(Voyage vIn) {
		//appel de la méthode Dao
		return voyageDao.add(vIn);
	}

	@Override
	public boolean deleteVoyage(Voyage vIn) {
		voyageDao.delete(vIn.getId());
		
		/**
		if (vOut!=null){
			//appel de la methode Dao pour supprimer le voyage
			voyageDao.delete(id);
			return true; 
		}
		return false;
		**/
		return true;
	}

	@Override
	public boolean updateVoyage(Voyage vIn) {
		// recuperer le voyage
		Voyage vOut = voyageDao.getById(vIn.getId());
		
		if (vOut!=null){
			
			// modifier l'objet récupéré avec les nouvelles valeurs en java
			vOut.setDateDebut(vIn.getDateDebut());
			vOut.setDateRetour(vIn.getDateRetour());
			vOut.setNombrePlace(vIn.getNombrePlace());
			
			vOut.setPrixAgence(vIn.getPrixAgence());
			vOut.setPrixBoVoyage(vIn.getPrixBoVoyage());
			
			vOut.setStatut(vIn.getStatut());
			vOut.setPhotos(vIn.getPhotos());

			//appel de la methode Dao pour supprimer le voyage
			voyageDao.update(vOut);
			return true; 
		}
		return false;
	}

}
