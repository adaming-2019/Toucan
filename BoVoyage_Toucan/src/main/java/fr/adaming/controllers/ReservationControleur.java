package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	public void setAssuService(IAssuranceService assuService) {
		this.assuService = assuService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		df.setLenient(false);
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	
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
		
		// création d'un nouveau dossier
		Dossier dossier = new Dossier();
		
		// attribution du statut "en attente" au dossier
		dossier.setEtat("en attente");
		
		// attribution d'un client et d'un voyage au dossier
		dossier.setClient(client);
		dossier.setVoyage(voyage);
		
		dossier.setVoyageurs(new ArrayList<Voyageur>());
		// passage du dossier comme attribut du modèle MVC
		model.addAttribute("dossier", dossier);
		
		return "choixNbPlacesCl";
		
	}
	
	//*** Fonctionnalité saisir voyageur
	@RequestMapping(value="/saisieVoyageur", method=RequestMethod.POST)
	public String submitChoixNbPlaces(HttpServletRequest req,ModelMap model, @ModelAttribute("dossier") Dossier dossier) {
		// passage du dossier comme attribut du modèle MVC
		System.out.println(dossier+"\n");
		
		dossier.setVoyageurs(new ArrayList<Voyageur>());
		HttpSession maSession=req.getSession();
		
		maSession.setAttribute("dossier", dossier);
		
		// ajout d'un nouveau voyageur comme attribut du modèle mvc
		model.addAttribute("voyageur", new Voyageur());
		
		// définition du numéro du voyageur à saisir, pour l'instant il s'agit du premier
		int noVoyageur=1;
		model.addAttribute("noVoyageur", noVoyageur);
		
		return "saisieVoyageurCl";
		
	}
	
	@RequestMapping(value="/submitSaisieVoyageur", method=RequestMethod.POST)
	public String submitSaisieVoyageur(HttpServletRequest req,ModelMap model, @ModelAttribute("voyageur") Voyageur voyageur, @RequestParam("noVoyageur") int noVoyageur) {
		// ajout du voyageur saisi à la liste des voyageurs associés au dossier
HttpSession maSession=req.getSession();
		
		
		
		Dossier dossier=(Dossier) maSession.getAttribute("dossier");
		dossier.getVoyageurs().add(voyageur);
		
		// passage du dossier comme attribut du modèle MVC
		maSession.setAttribute("dossier", dossier);
		System.out.println("\n ---------- soumettre voyageur");
		if(dossier.getVoyageurs().size()<dossier.getNbPlaces()) {
			// ajout d'un nouveau voyageur comme attribut du modèle mvc
			model.addAttribute("voyageur", new Voyageur());
			
			// incrémentation du numéro du voyageur à saisir
			noVoyageur++;
			model.addAttribute("noVoyageur", noVoyageur);
			
			return "saisieVoyageurCl";
			
		} else {
			// récupérer la liste des assurances et l'associer au modèle MVC
			List<Assurance> assurances = assuService.getAllAssurances();
			model.addAttribute("assurances", assurances);
			
			return "choixAssurance";
		}
		
	}

}
