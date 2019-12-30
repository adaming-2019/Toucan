package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.entities.Continent;
import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/public")
public class ContinentVoyageControleur {

	// Transformation de l'association UML en JAVA
	@Autowired
	private IVoyageService voyageService;

	@Autowired
	private IDestinationService destinationService;

	// setters pour l'injection de dépendance
	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}

	public void setDestinationService(IDestinationService destinationService) {
		this.destinationService = destinationService;
	}

	// convertir les valeurs des params de la requete en objets java, (ex: date)
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// WebDataBinder permet de faire le lien entre les params et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

	}

	// ============================= méthodes métier =============================

	@RequestMapping(value = "/afficheListeContinent", method = RequestMethod.GET)
	public String afficherContinent(Model modele) {
		List<Continent> listeContinents = new ArrayList<Continent>(Arrays.asList(Continent.values()));

		modele.addAttribute("listeCont", listeContinents);
		modele.addAttribute("destination", new Destination());

		return "accueilCl";
	}

	@RequestMapping(value = "/submitChoixContinent", method = RequestMethod.GET)
	public String soumettreChoixContinent(Model modele, @RequestParam("pContinent") Continent continentIn) {

		// appel de la méthode service
		List<Voyage> listeVoyage= voyageService.getVoyageByDestination(continentIn);
		
		modele.addAttribute("voyages", listeVoyage);

		return "listeVoyageCl";
	}

}
