package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Dossier;
import fr.adaming.service.IDossierService;

@Controller
@RequestMapping("/admin")
public class DossierController {

	//transformation de l'association UML en java
	@Autowired
	private IDossierService dservices;
	
	//setter pour l'injection de dépendance 
	public void setDservices(IDossierService dservices) {
		this.dservices = dservices;
	}
	
	
	//développement des méthodes 
	//afficher la liste des dossiers 
	@RequestMapping(value = "/listeDossiers", method = RequestMethod.GET)
	public ModelAndView afficherDossiers() {
		//récupérer liste dossiers 
		List<Dossier> listeDossiers=dservices.getAllDossier();
		return new ModelAndView("listeDossierAdm", "dossiers", listeDossiers);
				
	}
	
}
