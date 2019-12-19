package fr.adaming.service;

import java.util.List;

import javax.print.attribute.standard.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DestinationServiceImpl implements IDestinationService{

	// transformation de l'association UML en java
	private IDestinationService destinationDao;
	
	@Autowired
	public void setDestinationDao(IDestinationService destinationDao) {
		this.destinationDao = destinationDao;
	}

	@Override
	public List<Destination> getAll() {
	
		return destinationDao.getAll();
	}

	@Override
	public Destination getById(int Did) {
		
		return destinationDao.getById(Did);
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
