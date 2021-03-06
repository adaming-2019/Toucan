package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormuleDao;
import fr.adaming.entities.Formule;


@Service
@Transactional
public class FormuleServiceImpl implements IFormuleService {
	// transformation de l'association UML en java
	
	private IFormuleDao formDao;

	// le setter pour l'injection de dependance
	@Autowired
	public void setFormDao(IFormuleDao formDao) {
		this.formDao = formDao;
	}

	
	@Override
	public List<Formule> getall() {
		
		return formDao.getAll();
	}


	@Override
	public Formule getById(int fId) {
		
		return formDao.getById(fId);
	}

	@Override
	public Formule add(Formule fId) {
		
		return formDao.add(fId);
	}

	@Override
	public Formule update(Formule fId) {
		
		return formDao.update(fId);
	}

	@Override
	public boolean delete(Formule fIn) {
		formDao.delete(fIn.getId());
		return true;
		

	}

}
