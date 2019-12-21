package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.entities.Agence;

@Service
@Transactional
public class AgenceServiceImpl implements IAgenceService {

	// transformation de l'association UML en JAVA
	private IAgenceDao agenceDao;

	@Autowired
	public void setAgenceDao(IAgenceDao agenceDao) {
		this.agenceDao = agenceDao;
	}

	@Override
	public List<Agence> getAllAgence() {
		// appel de la méthode
		return agenceDao.getAll();
	}

	@Override
	public Agence getById(int id) {
		// appel de la méthode
		return agenceDao.getById(id);
	}

	@Override
	public Agence addAgence(Agence agenceIn) {
		// appel de la méthode
		return agenceDao.add(agenceIn);
	}

	@Override
	public Agence update(Agence agenceIn) {
		// appel de la méthode
		return agenceDao.update(agenceIn);
	}

	@Override
	public boolean deleteAgence(int id) {
		agenceDao.delete(id);
		return true;

	}

}
