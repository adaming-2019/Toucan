package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Continent;

@Controller
@RequestMapping("/client/continent")
public class ContinentPaysControleur {

	@RequestMapping(value = "/afficheContinent", method = RequestMethod.GET)
	public String afficherContinent(Model modele) {
		List<Continent> listeContinents = new ArrayList<Continent>(Arrays.asList(Continent.values()));
		
		modele.addAttribute("listeCont", listeContinents);
		
		return "continentClient";
	}
	
	
	
	
	
	
	
	
	
	
}
