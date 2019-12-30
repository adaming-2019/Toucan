package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	//transformation UML en java
	@Autowired
	private IDestinationService destiService;

	public void setDestiService(IDestinationService destiService) {
		this.destiService = destiService;
	}
	
	//développement des méthodes 
		//afficher la liste des dossiers
	@RequestMapping(value = "/listeDestinations", method = RequestMethod.GET)
	public ModelAndView afficherDestinations() {
		//récupérer liste dossiers 
		List<Destination> listeDestinations=destiService.getAll();
		return new ModelAndView("listeDestinationsAdm", "destination", listeDestinations);	
	}
	
	//supprimer une destination
	@RequestMapping(value = "/deleteDestination", method = RequestMethod.GET)
	public String supprimerDestination() {
		return "supprimerDestiantionAdm";
	}
	
	@RequestMapping(value = "/submitDestination", method = RequestMethod.GET)
	public String afficherDestination(RedirectAttributes rda, @RequestParam("pId") int idIn) {

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

	
}
