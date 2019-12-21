package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILoueurVehiculeDao;
import fr.adaming.dao.LoueurVehiculeDaoImpl;

import fr.adaming.entities.LoueurVehicule;

@Service
@Transactional
public class LoueurVehiculeServiceImpl implements ILoueurVehiculeService {

	// Transformation de l'association UML en java
	ILoueurVehiculeDao cvService = new LoueurVehiculeDaoImpl();

	@Override
	public List<LoueurVehicule> getAll() {
		return cvService.getAll();
	}

	@Override
	public LoueurVehicule getById(int id) {

		return cvService.getById(id);
	}

	@Override
	public LoueurVehicule add(LoueurVehicule cv) {

		return cvService.add(cv);
	}

	@Override
	public LoueurVehicule update(LoueurVehicule cv) {
		return cvService.update(cv);
	}

	@Override
	public boolean delete(int id) {
		cvService .delete(id);
		return true;

	}

}
