package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageurDao;
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
		// appel de la m�thode dao
		return voyageurDao.getAll();
	}

	@Override
	public Voyageur getVoyageurById(Voyageur vrIn) {
		// appel de la m�thode dao
		return voyageurDao.getById(vrIn.getId());
	}

	@Override
	public Voyageur addVoyageur(Voyageur vrIn) {
		//appel de la m�thode Dao
		return voyageurDao.add(vrIn);
	}

	@Override
	public boolean deleteVoyageur(Voyageur vrIn) {
		voyageurDao.delete(vrIn.getId());
		return true;
	}

	@Override
	public boolean updateVoyageur(Voyageur vrIn) {
		// recuperer le voyageur
		Voyageur vrOut = voyageurDao.getById(vrIn.getId());
		
		if (vrOut!=null){
			
			// modifier l'objet r�cup�r� avec les nouvelles valeurs en java
			vrOut.setDossier(vrIn.getDossier());
			vrOut.setNumSiege(vrIn.getNumSiege());

			//appel de la methode Dao pour supprimer le voyageur
			voyageurDao.update(vrOut);
			return true; 
		}
		return false;
	}

	@Override
	public Voyageur updateVoyageurClient(Voyageur eIn) {
		// appel de la m�thode dao
		return voyageurDao.update(eIn);
	}

}
