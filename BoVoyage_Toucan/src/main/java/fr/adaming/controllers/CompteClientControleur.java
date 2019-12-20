package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyage;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDossierService;

@Controller
public class CompteClientControleur {
	
	// transformation de l'association uml en java
	@Autowired
	private IClientService clService;
	@Autowired
	private IDossierService dosService;

	// setters pour l'injection de dépendance
	public void setClService(IClientService clService) {
		this.clService = clService;
	}
	
	public void setDosService(IDossierService dosService) {
		this.dosService = dosService;
	}
	
	// méthodes métier
	
	// affichage de la page login
	public String afficheLoginCl(Model model) {
		model.addAttribute("client", new Client());
		
		return "loginCl";
	}
	
	// ***Fonctionnalité choisir nombre de places
	public String afficheChoixNbPlaces(Model model) {
		Voyage voyage = new Voyage();
		voyage.setId(3);
		
		Client client = new Client();
		client.setId(5);
		
		Dossier dossier = new Dossier();
		dossier.setEtat("en attente");
		dossier.setClient(client);
		dossier.setVoyage(voyage);
		
		Dossier verif = dosService.addDossier(dossier);
		
		if (verif.getId()!=0) {
			model.addAttribute("dossier", dossier);
			
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
