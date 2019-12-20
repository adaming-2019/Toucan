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

	//setter pour l'injection de d�pendance
	public void setVrService(IVoyageurService vrService) {
		this.vrService = vrService;
	}
	
	//convertir les valeurs des param�tres en objet java (ici la date de naissance)
	
	
	
	
	//d�veloppement des m�thodes. 
	
	
}
