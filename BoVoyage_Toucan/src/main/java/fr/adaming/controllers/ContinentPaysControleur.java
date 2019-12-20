package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Continent;
import fr.adaming.entities.Destination;
import fr.adaming.entities.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/client/continent")
public class ContinentPaysControleur {

	// Transformation de l'association UML en JAVA
	@Autowired
	private IVoyageService voyageService;

	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}

	@RequestMapping(value = "/afficheContinent", method = RequestMethod.GET)
	public String afficherContinent(Model modele) {
		List<Continent> listeContinents = new ArrayList<Continent>(Arrays.asList(Continent.values()));

		modele.addAttribute("listeCont", listeContinents);
		modele.addAttribute("destination", new Destination());

		return "continentClient";
	}

	@RequestMapping(value = "/afficheContinent", method = RequestMethod.POST)
	public String afficherVoyage(Model modele, @ModelAttribute("destination") Destination destination) {
		
		
		
		
		
		
		

		return "voyageClient";
	}

}
