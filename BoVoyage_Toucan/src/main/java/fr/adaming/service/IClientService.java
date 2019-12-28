package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;

public interface IClientService {

	// les méthodes pour client
	public List<Client> getAllClients();
	
	public Client getClientById(int id);
	
	public Client addClient(Client clIn);
	
	public Client updateClient(Client clIn);
	
	public boolean deleteClient(int id);
	
}
