package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyage;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IVoyageService;

@Controller
public class CompteClientControleur {
	
	// transformation de l'association uml en java
	@Autowired
	private IClientService clService;
	@Autowired
	private IDossierService dosService;
	@Autowired
	private IVoyageService voyService;

	// setters pour l'injection de dépendance
	public void setClService(IClientService clService) {
		this.clService = clService;
	}
	
	public void setDosService(IDossierService dosService) {
		this.dosService = dosService;
	}
	
	public void setVoyService(IVoyageService voyService) {
		this.voyService = voyService;
	}
	
	// méthodes métier
	
	// affichage de la page login
	public String afficheLoginCl(Model model) {
		model.addAttribute("client", new Client());
		
		return "loginCl";
	}
	
	// ***Fonctionnalité choisir nombre de places
	@RequestMapping(value="/choixNbPlaces", method=RequestMethod.GET)
	public String afficheChoixNbPlaces(Model model) {
		Voyage voyage = new Voyage();
		voyService.addVoyage(voyage);
		
		Client client = new Client();
		clService.addClient(client);
		
		Dossier dossier = new Dossier();
		dossier.setEtat("en attente");
		dossier.setClient(client);
		dossier.setVoyage(voyage);
		
		Dossier dossierAdd = dosService.addDossier(dossier);
		
		if (dossierAdd.getId()!=0) {
			model.addAttribute("dossier", dossierAdd);
			
			return "choixNbPlacesCl";
			
		} else {
			return "loginCl";
		}
		
	}
	
	
//	public String submitChoixNbPlaces(Model model, @ModelAttribute("dossier") Dossier dossier) {
//		
//		Dossier dossierOut = dosService.updateDossier(dossier);
//		
//		model.addAttribute("dossier", dossierOut);
//		
//	}

}
