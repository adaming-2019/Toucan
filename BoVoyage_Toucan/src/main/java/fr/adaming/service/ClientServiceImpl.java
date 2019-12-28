package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	// transformation de l'association UML en java
	private IClientDao clientDao;

	@Autowired
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> getAllClients() {
		// appel de la méthode dao
		return clientDao.getAll();
	}

	@Override
	public Client getClientById(int id) {
		// appel de la méthode dao
		return clientDao.getById(id);
	}

	@Override
	public Client addClient(Client clIn) {
		// appel de la méthode Dao
		return clientDao.add(clIn);
	}

	@Override
	public Client updateClient(Client clIn) {
		//appel de la methode Dao
		return clientDao.update(clIn);
	}
	
	@Override
	public boolean deleteClient(int id) {
		clientDao.delete(id);
		return true;
	}

}
