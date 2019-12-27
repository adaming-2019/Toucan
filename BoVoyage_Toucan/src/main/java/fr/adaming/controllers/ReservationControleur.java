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
import fr.adaming.entities.ChoixAssurance;
import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyage;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/client")
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
	@RequestMapping(value = "/choixNbPlaces", method = RequestMethod.GET)
	public String afficheChoixNbPlaces(Model model) {
		Voyage voyage = voyService.getVoyageById(44);

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
		
		

		return "choixNbPlacesCl";

	}

	// *** Fonctionnalité saisir voyageur
	@RequestMapping(value = "/saisieVoyageur", method = RequestMethod.POST)
	public String submitChoixNbPlaces(HttpServletRequest req, ModelMap model,
			@ModelAttribute("dossier") Dossier dossier) {
		// passage du dossier comme attribut du modèle MVC
		System.out.println(dossier + "\n");

		dossier.setVoyageurs(new ArrayList<Voyageur>());
		HttpSession maSession = req.getSession();

		maSession.setAttribute("dossier", dossier);

		// ajout d'un nouveau voyageur comme attribut du modèle mvc
		model.addAttribute("voyageur", new Voyageur());

		// définition du numéro du voyageur à saisir, pour l'instant il s'agit du
		// premier
		int noVoyageur = dossier.getVoyageurs().size() + 1;
		model.addAttribute("noVoyageur", noVoyageur);

		return "saisieVoyageurCl";

	}

	@RequestMapping(value = "/submitSaisieVoyageur", method = RequestMethod.POST)
	public String submitSaisieVoyageur(HttpServletRequest req, ModelMap model,
			@ModelAttribute("voyageur") Voyageur voyageur) {
		// ajout du voyageur saisi à la liste des voyageurs associés au dossier
		HttpSession maSession = req.getSession();

		Dossier dossier = (Dossier) maSession.getAttribute("dossier");
		dossier.getVoyageurs().add(voyageur);

		// passage du dossier comme attribut du modèle MVC
		maSession.setAttribute("dossier", dossier);
		System.out.println("\n ---------- soumettre voyageur");
		if (dossier.getVoyageurs().size() < dossier.getNbPlaces()) {
			// ajout d'un nouveau voyageur comme attribut du modèle mvc
			model.addAttribute("voyageur", new Voyageur());

			// incrémentation du numéro du voyageur à saisir
			int noVoyageur = dossier.getVoyageurs().size() + 1;
			model.addAttribute("noVoyageur", noVoyageur);

			return "saisieVoyageurCl";

		} else {
			// récupérer la liste des assurances
			List<Assurance> assurances = assuService.getAllAssurances();
			
			// ajout au modele mvc
			model.addAttribute("assurances", assurances);
			
			// extraire la liste des types d'assurances et les stocker dans un String[]
			String[] liste = new String[assurances.size()];
			
			for (int i=0; i<assurances.size(); i++) {
				liste[i] = assurances.get(i).getType();
			}
			// ajout de ce String[] au modèle MVC
			model.addAttribute("types", liste);
			
			// instanciation d'un objet de type ChoixAssurance, pour stocker les assurances sélectionnées par le client
			ChoixAssurance selection = new ChoixAssurance();
			selection.setChoix(new ArrayList<String>());
			
			// ajout de selection au modele mvc
			model.addAttribute("selection", selection);

			return "choixAssuranceCl";
		}

	}
	
	@RequestMapping(value="/submitChoixAssurance", method=RequestMethod.POST)
	public String submitChoixAssurance(HttpServletRequest req, Model model, @ModelAttribute(value="selection") ChoixAssurance selection) {
		// récupérer le dossier stocké dans la session
		HttpSession maSession = req.getSession();

		Dossier dossier = (Dossier) maSession.getAttribute("dossier");
		
		System.out.println(selection);
		
		dossier.setAssurances(new ArrayList<Assurance>());
		
		// prix à régler par le client sans les assurances
		double prix = dossier.getVoyage().getPrixBoVoyage();
		
		for (String elem : selection.getChoix()) {
			if (elem!=null) {
				// récupérer l'assurance dans la bd
				Assurance assuranceOut = assuService.getAssuranceByType(elem);
				System.out.println(assuranceOut);
				// ajout de cette assurance à la liste des assurances du dossier
				dossier.getAssurances().add(assuranceOut);
				
				// maj du prix total à régler par le client
				prix+=assuranceOut.getMontant();
			}
		}
		
		model.addAttribute("dossier", dossier);
		model.addAttribute("total", prix);
		
		return "recapitulatifCl";
		
	}
	
	@RequestMapping(value="/validerReservation", method=RequestMethod.GET)
	public String validerReservation(HttpServletRequest req, Model model) {
		// récupérer le dossier stocké dans la session
		HttpSession maSession = req.getSession();

		Dossier dossier = (Dossier) maSession.getAttribute("dossier");
		
		// ajout du dossier à la bd
		Dossier ajout = dosService.addDossier(dossier);
		// les voyageurs seront automatiquement ajoutés à la bd
		
		// supprimer le dossier de la session
		maSession.removeAttribute("dossier");
		
		if (ajout.getId()!=0) {
			return "menuCl";
		} else {
			return "recapitulatifCl";
		}
		
	}

}
