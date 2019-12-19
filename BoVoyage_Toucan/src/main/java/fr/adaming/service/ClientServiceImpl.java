package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService{

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientById(Client clIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client addClient(Client clIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteClient(Client clIn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClient(Client clIn) {
		// TODO Auto-generated method stub
		return false;
	}

}
