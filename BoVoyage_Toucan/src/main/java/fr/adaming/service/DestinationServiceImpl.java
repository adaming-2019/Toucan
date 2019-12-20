package fr.adaming.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.entities.Destination;

@Service
@Transactional
public class DestinationServiceImpl implements IDestinationService{

	// transformation de l'association UML en java

	private IDestinationDao destinationDao;
	

	// le setter pour l'injection de dependance
	@Autowired
	public void setDestinationDao(IDestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}

	@Override
	public List<Destination> getAll() {
	
		return destinationDao.getAll();
	}

	@Override
	public Destination getById(int idD) {
		
		return destinationDao.getById(idD);
	}

	@Override
	public Destination add(Destination dIn) {
		
		return destinationDao.add(dIn);
	}

	@Override
	public Destination update(Destination dIn) {
		
		return destinationDao.update(dIn);
	}

	@Override
	public void delete(int id) {
	
		
	}

}
