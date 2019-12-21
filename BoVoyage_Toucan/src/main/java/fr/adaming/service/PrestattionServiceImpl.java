package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPrestationDao;
import fr.adaming.entities.Prestation;

@Service
@Transactional
public class PrestattionServiceImpl implements IPrestationService{

	//transformation de l'asscoiation UML en java
	private IPrestationDao prestDao;
	
	
	@Autowired
	public void setPrestDao(IPrestationDao prestDao) {
		this.prestDao = prestDao;
	}

	@Override
	public List<Prestation> getAll() {

		return prestDao.getAll();
	}

	@Override
	public Prestation getById(int pId) {
		
		return prestDao.getById(pId);
	}

	@Override
	public Prestation add(Prestation pId) {
		
		return prestDao.add(pId);
		
	}

	@Override
	public Prestation update(Prestation pId) {
		
		return prestDao.update(pId);
	}

	@Override
	public boolean delete(Prestation pIn) {
		prestDao.delete(pIn.getId());
		return true;
		
		
	}

}
