package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDossierDao;
import fr.adaming.entities.Dossier;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {

	// transformation de l'association UML en JAVA
	@Autowired
	private IDossierDao dossierDao;

	public void setDossierDao(IDossierDao dossierDao) {
		this.dossierDao = dossierDao;
	}

	@Override
	public List<Dossier> getAllDossier() {
		// appel de la m�thode
		return dossierDao.getAll();
	}

	@Override
	public Dossier getById(int id) {
		// appel de la m�thode
		return dossierDao.getById(id);
	}

	@Override
	public Dossier addDossier(Dossier dossierIn) {
		// appel de la m�thode
		return dossierDao.add(dossierIn);
	}

	@Override
	public boolean updateDossier(Dossier dossierIn) {
		dossierDao.update(dossierIn);
		return true;
	}

	@Override
	public boolean deleteDossier(int id) {
		dossierDao.delete(id);
		return true;

	}

}
