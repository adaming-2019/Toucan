package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;

public interface IClientService {

	public List<Client> getAllClients();
	
	public Client getClientById(Client clIn);
	
	public Client addClient(Client clIn);
	
	public boolean deleteClient(Client clIn);
	
	public boolean updateClient(Client clIn);
	
}
