package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.IVoyageurService;

@Controller
@RequestMapping("/admin")
public class VoyageurController {

	
	//transformation UML en java 
	@Autowired
	private IVoyageurService vrService;

	//setter pour l'injection de dépendance
	public void setVrService(IVoyageurService vrService) {
		this.vrService = vrService;
	}
	
	//convertir les valeurs des paramètres en objet java (ici la date de naissance)
	
	
	
	
	//développement des méthodes. 
	
	
}
