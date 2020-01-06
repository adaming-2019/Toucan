package fr.adaming.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import fr.adaming.entities.Destination;
import fr.adaming.entities.Image;
import fr.adaming.service.IDestinationService;

@Controller
@RequestMapping("/admin")
public class DestinationController {

	// transformation UML en java
	@Autowired
	private IDestinationService destiService;

	// développement des méthodes
	// afficher la liste des dossiers
	@RequestMapping(value = "/listeDestinations", method = RequestMethod.GET)
	public ModelAndView afficherDestinations() {
		// récupérer liste dossiers
		List<Destination> listeDestinations = destiService.getAll();
		return new ModelAndView("listeDestinationsAdm", "destinations", listeDestinations);
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

	@RequestMapping(value = "/addDestination", method = RequestMethod.POST)
	public String addDestination(@ModelAttribute("destiAdd") Destination dIn,
			@RequestParam("files") MultipartFile[] files, ModelMap modele) {
		// appel de la méthode service

		System.out.println("=======================  " + files.length);
		System.out.println("=======================  " + dIn);
		if (files.length != 0) {
			
			List<Image> listeImages=new ArrayList<Image>();
			for (MultipartFile file : files) {
				Image image = new Image();
				try {
					image.setPhoto(file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				image.setDestination(dIn);
				listeImages.add(image);
			}
			dIn.setImages(listeImages);
		}
		Destination dOut = destiService.add(dIn);

		if (dOut.getId() != 0) {
			// récupérer la liste des destinations
			List<Destination> listeDestinations = destiService.getAll();

			modele.addAttribute("destinations", listeDestinations);
			return "listeDestinationsAdm";
		} else {
			return "redirect:ajoutDestination";
		}

	}
}