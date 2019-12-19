package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;
import fr.adaming.entities.Traveller;


@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client>implements IClientDao{

	// specifier le vrai type de T (la vraie Entity à utiliser ) ici c'est Client
	public ClientDaoImpl() {
		clazz=Client.class;
	}
}

