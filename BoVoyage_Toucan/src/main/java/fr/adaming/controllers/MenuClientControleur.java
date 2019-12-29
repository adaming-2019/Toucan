package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IDossierService;

@Controller
@RequestMapping("/client")
public class MenuClientControleur {
	
	// déclaration des attributs
	private Client client;
	
	// transformation de l'association uml en java
	@Autowired
	private IDossierService dosService;

	// setters pour l'injection de dépendance
	public void setDosService(IDossierService dosService) {
		this.dosService = dosService;
	}
	
	// méthode pour instancier l'attribut client lors de l'instanciation du controleur
	@PostConstruct
	public void init() {
		this.client = new Client();
		this.client.setId(57);
	}
	
	// méthodes métiers
	
	// affichage de la liste des dossiers
	@RequestMapping(value="/listeDossiers", method=RequestMethod.GET)
	public String afficheListeDossiers(Model model) {
		// appel de la méthode service
		List<Dossier> listeDossiers = dosService.getAllByClient(this.client);
		
		// associer la liste des dossiers au modele mvc
		model.addAttribute("dossiers", listeDossiers);
		
		return "menuCl";
	}
	
	@RequestMapping(value="/detailsDossier", method=RequestMethod.GET)
	public String afficheDetailsDossier(Model model, @RequestParam("pIdDossier") int idIn) {
		
		// récupération des données du dossier dans la bd
		Dossier dossier = dosService.getById(idIn);
		
		// ajout du dossier récupéré au modele mvc
		model.addAttribute("dossier", dossier);
		
		// récupération de la liste de voyageurs associée au dossier
		List<Voyageur> voyageurs = dossier.getVoyageurs();
		
		for (Voyageur v : voyageurs) {
			System.out.println(v);
		}
		
		// ajout de la liste de voyageurs au modele mvc
		model.addAttribute("voyageurs", voyageurs);
		
		
		return "infosDossierCl";
	}
	

}
