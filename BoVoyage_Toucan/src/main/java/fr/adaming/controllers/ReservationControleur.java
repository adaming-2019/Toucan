package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Assurance;
import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyage;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/public")
public class ReservationControleur {
	
	// transformation de l'association uml en java
	@Autowired
	private IClientService clService;
	@Autowired
	private IDossierService dosService;
	@Autowired
	private IVoyageService voyService;
	@Autowired
	private IAssuranceService assuService;

	// setters pour l'injection de d�pendance
	public void setClService(IClientService clService) {
		this.clService = clService;
	}
	
	public void setDosService(IDossierService dosService) {
		this.dosService = dosService;
	}
	
	public void setVoyService(IVoyageService voyService) {
		this.voyService = voyService;
	}
	
	public void setAssuService(IAssuranceService assuService) {
		this.assuService = assuService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Je suis dans la m�thode initBinder");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		df.setLenient(false);
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		System.out.println("Je sors de la m�thode submitSaisieVoyageur");
	}
	
	// m�thodes m�tier

	// affichage de la page login
	public String afficheLoginCl(Model model) {
		model.addAttribute("client", new Client());
		
		return "loginCl";
	}
	
	// ***Fonctionnalit� choisir nombre de places
	@RequestMapping(value="/choixNbPlaces", method=RequestMethod.GET)
	public String afficheChoixNbPlaces(Model model) {
		Voyage voyage = new Voyage();
		voyService.addVoyage(voyage);
		
		Client client = new Client();
		clService.addClient(client);
		
		// cr�ation d'un nouveau dossier
		Dossier dossier = new Dossier();
		
		// attribution du statut "en attente" au dossier
		dossier.setEtat("en attente");
		
		// attribution d'un client et d'un voyage au dossier
		dossier.setClient(client);
		dossier.setVoyage(voyage);
		
		// passage du dossier comme attribut du mod�le MVC
		model.addAttribute("dossier", dossier);
		
		return "choixNbPlacesCl";
		
	}
	
	//*** Fonctionnalit� saisir voyageur
	@RequestMapping(value="/saisieVoyageur", method=RequestMethod.POST)
	public String submitChoixNbPlaces(Model model, @ModelAttribute("dossier") Dossier dossier) {
		System.out.println("Je suis dans la m�thode submitChoixNbPlaces");
		// passage du dossier comme attribut du mod�le MVC
		model.addAttribute("dossier", dossier);
		
		// ajout d'un nouveau voyageur comme attribut du mod�le mvc
		model.addAttribute("voyageur", new Voyageur());
		System.out.println("J'ai ajout� le voyageur au mod�le mvc");
		
		// d�finition du num�ro du voyageur � saisir, pour l'instant il s'agit du premier
		int noVoyageur=1;
		model.addAttribute("noVoyageur", noVoyageur);
		
		System.out.println("J'ai ajout� le noVoyageur au mod�le mvc");
		
		return "saisieVoyageurCl";
		
	}
	
	@RequestMapping(value="/submitSaisieVoyageur", method=RequestMethod.POST)
	public String submitSaisieVoyageur(Model model, @ModelAttribute("dossier") Dossier dossier, @ModelAttribute("voyageur") Voyageur voyageur, @ModelAttribute("noVoyageur") int noVoyageur) {
		// ajout du voyageur saisi � la liste des voyageurs associ�s au dossier
		System.out.println("Je suis dans la m�thode submitSaisieVoyageur");
		dossier.getVoyageurs().add(voyageur);
		System.out.println("J'ai ajout� le voyageur au dossier");
		
		// passage du dossier comme attribut du mod�le MVC
		model.addAttribute("dossier", dossier);
		
		if(dossier.getVoyageurs().size()<dossier.getNbPlaces()) {
			// ajout d'un nouveau voyageur comme attribut du mod�le mvc
			model.addAttribute("voyageur", new Voyageur());
			
			// incr�mentation du num�ro du voyageur � saisir
			noVoyageur++;
			model.addAttribute("noVoyageur", noVoyageur);
			
			return "saisieVoyageurCl";
			
		} else {
			// r�cup�rer la liste des assurances et l'associer au mod�le MVC
			List<Assurance> assurances = assuService.getAllAssurances();
			model.addAttribute("assurances", assurances);
			
			return "choixAssurance";
		}
		
	}

}
