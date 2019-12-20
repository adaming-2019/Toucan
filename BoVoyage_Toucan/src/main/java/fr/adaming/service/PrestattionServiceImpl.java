package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Prestation;

public class PrestattionServiceImpl implements IPrestationService{

	//transformation de l'asscoiation UML en java
	private IPrestationService prestDao;
	
	
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
	public void delete(Prestation id) {
		
		
	}

}
