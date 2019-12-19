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
	public void setEtuDao(IVoyageDao voyageDao) {
		this.voyageDao = voyageDao;
	}
	
		
	@Override
	public List<Voyage> getAllVoyages() {
		// appel de la m�thode dao
		return voyageDao.getAllVoyages();
	}

	@Override
	public Voyage getVoyageById(Voyage vIn) {
		// appel de la m�thode dao
		return voyageDao.getVoyageById(vIn);
	}

	@Override
	public Voyage addVoyage(Voyage vIn) {
		//appel de la m�thode Dao
		return voyageDao.addVoyage(vIn);
	}

	@Override
	public boolean deleteVoyage(Voyage vIn) {
		Voyage vOut = voyageDao.getVoyageById(vIn);
		
		if (vOut!=null){
			//appel de la methode Dao pour supprimer le voyage
			voyageDao.deleteVoyage(vOut);
			return true; 
		}
		return false;
	}

	@Override
	public boolean updateVoyage(Voyage vIn) {
		// recuperer le voyage
		Voyage vOut = voyageDao.getVoyageById(vIn);
		
		if (vOut!=null){
			
			// modifier l'objet r�cup�r� avec les nouvelles valeurs en java
			vOut.setDateDebut(vIn.getDateDebut());
			vOut.setDateRetour(vIn.getDateRetour());
			vOut.setNombrePlace(vIn.getNombrePlace());
			
			vOut.setPrixAgence(vIn.getPrixAgence());
			vOut.setPrixBoVoyage(vIn.getPrixBoVoyage());
			
			vOut.setStatut(vIn.getStatut());
			vOut.setPhotos(vIn.getPhotos());

			//appel de la methode Dao pour supprimer le voyage
			voyageDao.updateVoyage(vOut);
			return true; 
		}
		return false;
	}

}
