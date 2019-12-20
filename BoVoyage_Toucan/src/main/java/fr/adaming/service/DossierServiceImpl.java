package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDossierDao;
import fr.adaming.entities.Dossier;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService {

	// transformation de l'association UML en JAVA
	private IDossierDao dossierDao;

	public void setDossierDao(IDossierDao dossierDao) {
		this.dossierDao = dossierDao;
	}

	@Override
	public List<Dossier> getAllDossier() {
		// appel de la méthode
		return dossierDao.getAll();
	}

	@Override
	public Dossier getById(int id) {
		// appel de la méthode
		return dossierDao.getById(id);
	}

	@Override
	public Dossier addDossier(Dossier dossierIn) {
		// appel de la méthode
		return dossierDao.add(dossierIn);
	}

	@Override
	public Dossier updateDossier(Dossier dossierIn) {
		// appel de la méthode
		return dossierDao.update(dossierIn);
	}

	@Override
	public void deleteDossier(int id) {

	}

}
