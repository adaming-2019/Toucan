package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAssuranceDao;
import fr.adaming.entities.Assurance;

@Service
@Transactional
public class AssuranceServiceImpl implements IAssuranceService{

	// transformation de l'association UML en JAVA
	private IAssuranceDao assuranceDao;
	
	@Autowired
	public void setAssuranceDao(IAssuranceDao assuranceDao) {
		this.assuranceDao = assuranceDao;
	}

	@Override
	public List<Assurance> getAllAssurances() {
		// appel de la méthode
		return assuranceDao.getAll();
	}

	@Override
	public Assurance getById(int id) {
		// appel de la méthode
		return assuranceDao.getById(id);
	}

	@Override
	public Assurance addAssurance(Assurance assuranceIn) {
		// appel de la méthode
		return assuranceDao.add(assuranceIn);
	}

	@Override
	public Assurance update(Assurance assuranceIn) {
		// appel de la méthode
		return assuranceDao.update(assuranceIn);
	}

	@Override
	public boolean deleteAssurance(int id) {
		assuranceDao.delete(id);
		return true;
		
	}

	@Override
	public Assurance getAssuranceByType(String type) {
		// appel de la méthode service
		return assuranceDao.getAssuranceByType(type);
	}
	
	
	

}
