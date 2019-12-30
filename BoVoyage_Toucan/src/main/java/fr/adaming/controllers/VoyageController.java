package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Agence;
import fr.adaming.entities.CategorieVehicules;
import fr.adaming.entities.Continent;
import fr.adaming.entities.Destination;
import fr.adaming.entities.Formules;
import fr.adaming.entities.LoueurVehicules;
import fr.adaming.entities.Prestations;
import fr.adaming.entities.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
public class VoyageController {
	// Transformation de l'association uml en java
	@Autowired
	private IVoyageService voyageService;

	// Setter pour injection dépendance
	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// WebDataBinder permet de faire le lien entre les params et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

	}
	
	@RequestMapping(value = "/admin/listeVoyage", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// recup de la liste des voyages
		List<Voyage> listeVoyages = voyageService.getAllVoyages();
		
		System.out.println(listeVoyages);

		/**
	    String example = "This is an example";
	    byte[] bytes = example.getBytes();

	    System.out.println("Text : " + example);
	    System.out.println("Text [Byte Format] : " + bytes);
	    System.out.println("Text [Byte Format] : " + bytes.toString());

	    String s = new String(bytes);
	    System.out.println("Text Decryted : " + s);

		Iterator iterator = listeVoyages.iterator();
		while(iterator.hasNext()) {
		    System.out.println(iterator.next()+"\n\n");
		}
		**/
		
		
		
		
		return new ModelAndView("listeVoyageAdm", "voyages", listeVoyages);
	}
	
	@RequestMapping(value = "/admin/afficherAddVoyage", method = RequestMethod.GET)
	public String afficheAjouter(Model model) {

		// Listes des enum
		/**
		List<Agences> listeFormules = new ArrayList<Agences>(Arrays.asList(Agences.values()));
		model.addAttribute("listeAgences", listeAgences);
		**/
		List<CategorieVehicules> listeCategorieVehicules = new ArrayList<CategorieVehicules>(Arrays.asList(CategorieVehicules.values()));
		model.addAttribute("listeCategorieVehicules", listeCategorieVehicules);
		/**
		List<Destinations> listeDestination = new ArrayList<Destinations>(Arrays.asList(Destinations.values()));
		model.addAttribute("listeDestinations", listeDestinations);
		**/
		List<Formules> listeFormules = new ArrayList<Formules>(Arrays.asList(Formules.values()));
		model.addAttribute("listeFormules", listeFormules);
		
		List<LoueurVehicules> listeLoueurVehicules = new ArrayList<LoueurVehicules>(Arrays.asList(LoueurVehicules.values()));
		model.addAttribute("listeLoueurVehicules", listeLoueurVehicules);
		
		List<Prestations> listePrestations = new ArrayList<Prestations>(Arrays.asList(Prestations.values()));
		model.addAttribute("listePrestations", listePrestations);

		model.addAttribute("voyageAdd", new Voyage());
		return "ajouterVoyageAdm";
	}

	@RequestMapping(value = "/admin/submitAddVoyage", method = RequestMethod.POST)
	public String soumettreAjouter(Model model, @ModelAttribute("voyageAdd") Voyage voyageIn) {
		// Appel de la méthode service
		Voyage vOut = voyageService.addVoyage(voyageIn);
		if (vOut.getId() != 0) {
			List<Voyage> listeVoyages = voyageService.getAllVoyages();

			// Mettre à jour la liste
			model.addAttribute("Voyages", listeVoyages);

			return "redirect:listeVoyage";
		} else {
			return "redirect:afficherAddVoyage";
		}
	}

	@RequestMapping(value = "/admin/afficherUpdateVoyage", method = RequestMethod.GET)
	public ModelAndView afficheModifier() {
		return new ModelAndView("modifierVoyageAdm", "vUpdate", new Voyage());
	}

	@RequestMapping(value = "/admin/submitUpdateVoyage", method = RequestMethod.POST)
	public String soumettreModifier(Model model, @ModelAttribute("vUpdate") Voyage voyageIn) {
		// Appel de la méthode service
		Voyage vOut = voyageService.updateVoyage(voyageIn);
		if (vOut != null) {
			return "redirect:listeVoyage";
		} else {
			return "redirect:afficherUpdateVoyage";
		}
	}

	/**
	@RequestMapping(value = "/admin/afficherDeleteVoyage", method = RequestMethod.GET)
	public String afficheSupprimer(Model model) {
		model.addAttribute("voyageDelete", new Voyage());
		return "modifierVoyageAdm";
	}

	@RequestMapping(value = "/admin/submitDeleteVoyage", method = RequestMethod.POST)
	public String soumettreSupprimer(Model model, @ModelAttribute("voyageDelete") Voyage voyageIn, @RequestParam("pId") int idIn) {
		// Appel de la méthode service
		boolean eOut = voyageService.deleteVoyage(idIn);
		if (eOut != false) {
			List<Voyage> listeVoyages = voyageService.getAllVoyages();

			// Mettre à jour la liste
			model.addAttribute("Voyages", listeVoyages);

			return "redirect:listeVoyage";
		} else {
			return "redirect:afficherDeleteVoyage";
		}
	}
	**/

	@RequestMapping(value = "/admin/afficherDeleteVoyage", method = RequestMethod.GET)
	public String afficheSupprimer() {
		return "modifierVoyageAdm";
	}

	@RequestMapping(value = "/admin/submitDeleteVoyage", method = RequestMethod.GET)
	public String soumettreSupprimer(RedirectAttributes rda, @RequestParam("pId") int idIn) {

		// Appel de la méthode service
		boolean eOut = voyageService.deleteVoyage(idIn);
		if (eOut != false) {
			return "redirect:listeVoyage";
		} else {
			return "redirect:afficherDeleteVoyage";
		}
	}
	
	// Lien pour modif
	@RequestMapping(value="/admin/linkUpdateVoyage", method=RequestMethod.GET)
	public String getModifLien(Model modele, @RequestParam("pId") int idIn) {
		
		Voyage vOut = voyageService.getVoyageById(idIn);
		
		modele.addAttribute("vUpdate", vOut);
		
		return "modifierVoyageAdm";
		
	}
	
	
	
}
