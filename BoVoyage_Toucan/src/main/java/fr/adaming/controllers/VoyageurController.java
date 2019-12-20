package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.adaming.service.IVoyageurService;

@Controller
public class VoyageurController {

	
	//transformation UML en java 
	@Autowired
	private IVoyageurService vrService;

	//setter pour l'injection de d�pendance
	public void setVrService(IVoyageurService vrService) {
		this.vrService = vrService;
	}
	
	
	//d�veloppement des m�thodes. 
	
	
}
