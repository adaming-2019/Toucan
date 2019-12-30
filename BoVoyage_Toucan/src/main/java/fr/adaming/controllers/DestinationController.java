package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Destination;
import fr.adaming.service.IDestinationService;

@Controller
@RequestMapping("/admin")
public class DestinationController {

	// transformation UML en java
	@Autowired
	private IDestinationService destiService;

	public void setDestiService(IDestinationService destiService) {
		this.destiService = destiService;
	}

	// développement des méthodes
	// afficher la liste des dossiers
	@RequestMapping(value = "/listeDestinations", method = RequestMethod.GET)
	public ModelAndView afficherDestinations() {
		// récupérer liste dossiers
		List<Destination> listeDestinations = destiService.getAll();
		return new ModelAndView("listeDestinationsAdm", "destinations", listeDestinations);
	}

	// supprimer une destination
	@RequestMapping(value = "/deleteDestination", method = RequestMethod.GET)
	public String supprimerDestination() {
		return "supprimerDestiantionAdm";
	}

	@RequestMapping(value = "/suppDestination", method = RequestMethod.GET)
	public String deleteDestination(RedirectAttributes rda, @RequestParam("pId") int idIn) {

		Destination dIn = new Destination();
		dIn.setId(idIn);

		boolean verif = destiService.delete(idIn);
		if (verif) {
			return "redirect:listeDestinations";
		} else {
			// l'objet RedirectAttributes sert à transporter les attributs du
			// modele mvc lors de la redirection
			rda.addFlashAttribute("msg", "La destination n'existe pas");
			return "redirect:deleteDestination";
		}

	}

	// ajouter une destination
	@RequestMapping(value = "/ajoutDestination", method = RequestMethod.GET)
	public String ajouterDestination(Model modele) {
		modele.addAttribute("destiAdd", new Destination());
		return "ajouterDestinationAdm";
	}

@RequestMapping(value="/addDestination", method=RequestMethod.POST)
	public String addDestination (ModelMap modele, @ModelAttribute("destiAdd") Destination dIn) {
		// appel de la méthode service
		Destination dOut=destiService.add(dIn);
		
		if(dOut.getId()!=0) {
			// récupérer la liste des destinations
			List<Destination> listeDestinations=destiService.getAll();
			
			modele.addAttribute("destinations", listeDestinations);
			return "listeDestinationsAdm";
		}else {
			
		}return "redirect:ajoutDestination";
		
		
	}
}