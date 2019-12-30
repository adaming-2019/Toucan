package fr.adaming.service;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.strategy.BaseInstantiatorStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.entities.Continent;
import fr.adaming.entities.Destination;
import fr.adaming.entities.Image;

@Service
@Transactional
public class DestinationServiceImpl implements IDestinationService {

	// transformation de l'association UML en java

	private IDestinationDao destinationDao;

	// le setter pour l'injection de dependance
	@Autowired
	public void setDestinationDao(IDestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}

	@Override
	public List<Destination> getAll() {
		List<Destination> liste = destinationDao.getAll();

		for (Destination d : liste) {
			for (Image img : d.getImages()) {
				img.setPhotoString("data:image/gif;base64," + Base64.encodeBase64String(img.getPhoto()));
			}
		}
		return liste;
	}

	@Override
	public Destination getById(int idD) {

		Destination d = destinationDao.getById(idD);

		for (Image img : d.getImages()) {
			img.setPhotoString("data:image/gif;base64," + Base64.encodeBase64String(img.getPhoto()));
		}
		return d;
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
	public boolean delete(int id) {
		destinationDao.delete(id);
		return true;

	}

}
