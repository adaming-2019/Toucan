package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.dao.IVoyageurDao;
import fr.adaming.entities.Voyage;
import fr.adaming.entities.Voyageur;

@Service
@Transactional
public class VoyageurServiceImpl implements IVoyageurService {

	// transformation de l'association UML en java
	private IVoyageurDao voyageurDao;
	
	@Autowired
	public void setVoyageurDao(IVoyageurDao voyageurDao) {
		this.voyageurDao = voyageurDao;
	}
	
	@Override
	public List<Voyageur> getAllVoyageurs() {
		// appel de la méthode dao
		return voyageurDao.getAll();
	}

	@Override
	public Voyageur getVoyageurById(Voyageur vrIn) {
		// appel de la méthode dao
		return voyageurDao.getById(vrIn.getId());
	}

	@Override
	public Voyageur addVoyageur(Voyageur vrIn) {
		//appel de la méthode Dao
		return voyageurDao.add(vrIn);
	}

	@Override
	public boolean deleteVoyageur(Voyageur vrIn) {
		voyageurDao.delete(vrIn.getId());
		return true;
	}

	@Override
	public boolean updateVoyageur(Voyageur vrIn) {
		// recuperer le voyage
		Voyageur vrOut = voyageurDao.getById(vrIn.getId());
		
		if (vrOut!=null){
			
			// modifier l'objet récupéré avec les nouvelles valeurs en java
			vrOut.setDateDebut(vrIn.getDateDebut());
			vrOut.setDateRetour(vrIn.getDateRetour());

			//appel de la methode Dao pour supprimer le voyage
			voyageDao.update(vOut);
			return true; 
		}
		return false;
	}
	}

}
