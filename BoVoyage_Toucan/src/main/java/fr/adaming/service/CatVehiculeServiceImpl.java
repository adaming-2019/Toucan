package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.CatVehiculeDaoImpl;
import fr.adaming.dao.ICatVehiculeDao;
import fr.adaming.entities.CategorieVehicule;

@Service
@Transactional
public class CatVehiculeServiceImpl implements ICatVehiculeService {

	// Transformation de l'association UML en java
	ICatVehiculeDao cvService = new CatVehiculeDaoImpl();

	@Override
	public List<CategorieVehicule> getAll() {
		return cvService.getAll();
	}

	@Override
	public CategorieVehicule getById(int id) {

		return cvService.getById(id);
	}

	@Override
	public CategorieVehicule add(CategorieVehicule cv) {

		return cvService.add(cv);
	}

	@Override
	public CategorieVehicule update(CategorieVehicule cv) {
		return cvService.update(cv);
	}

	@Override
	public boolean delete(int id) {
		cvService.delete(id);
		return true;

	}
}
