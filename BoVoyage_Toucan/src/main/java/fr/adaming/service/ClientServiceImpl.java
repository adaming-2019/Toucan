package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService{

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
	public Client getClientById(Client clIn) {
		// appel de la méthode dao
		return clientDao.getById(clIn.getId());
	}

	@Override
	public Client addClient(Client clIn) {
		//appel de la méthode Dao
		return clientDao.add(clIn);
	}

	@Override
	public boolean deleteClient(Client clIn) {
		clientDao.delete(clIn.getId());
		return true;
	}

	@Override
	public boolean updateClient(Client clIn) {
		// recuperer le voyage
		Client clOut = clientDao.getById(clIn.getId());
		
		if (clOut!=null){
			
			// modifier l'objet récupéré avec les nouvelles valeurs en java
			clOut.setCb(clIn.getCb());
			clOut.setLogin(clIn.getLogin());
			clOut.setMdp(clIn.getMdp());

			//appel de la methode Dao pour supprimer le client
			clientDao.update(clOut);
			return true; 
		}
		return false;
	}

}
