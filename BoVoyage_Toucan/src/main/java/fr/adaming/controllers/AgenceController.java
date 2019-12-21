package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Agence;
import fr.adaming.service.IAgenceService;

@Controller
public class AgenceController {
	// Transformation de l'association uml en java
	@Autowired
	private IAgenceService agenceService;

	// Le setter pour l'injection dépendance
	public void setAgenceService(IAgenceService agenceService) {
		this.agenceService = agenceService;
	}

	@RequestMapping(value = "/admin/listeAgence", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// recup de la liste des agence du formateur
		List<Agence> listeAgence = agenceService.getAllAgence();

		System.out.println(listeAgence);
		return new ModelAndView("listeAgenceAdm", "agences", listeAgence);
	}

	@RequestMapping(value = "/admin/afficherAddAgence", method = RequestMethod.GET)
	public String afficheAjouter(Model model) {
		model.addAttribute("agAdd", new Agence());
		model.addAttribute("agDelete", new Agence());
		return "ajouterAgenceAdm";
	}

	@RequestMapping(value = "/admin/submitAddAgence", method = RequestMethod.POST)
	public String soumettreAjouter(Model model, @ModelAttribute("agAdd") Agence aIn) {
		// Appel de la méthode service
		Agence eOut = agenceService.addAgence(aIn);
		if (eOut.getId() != 0) {
			List<Agence> listeAgences = agenceService.getAllAgence();

			// Mettre à jour la liste
			model.addAttribute("Agences", listeAgences);

			return "redirect:listeAgence";
		} else {
			return "redirect:afficherAddAgence";
		}
	}

	@RequestMapping(value = "/admin/afficherUpdateAgence", method = RequestMethod.GET)
	public String afficheModifier(Model model) {
		model.addAttribute("agUpdate", new Agence());
		return "modifierAgenceAdm";
	}

	@RequestMapping(value = "/admin/submitUpdateAgence", method = RequestMethod.POST)
	public String soumettreModifier(Model model, @ModelAttribute("agUpdate") Agence aIn) {
		// Appel de la méthode service
		Agence eOut = agenceService.update(aIn);
		if (eOut.getId() != 0) {
			List<Agence> listeAgences = agenceService.getAllAgence();

			// Mettre à jour la liste
			model.addAttribute("Agences", listeAgences);

			return "redirect:listeAgence";
		} else {
			return "redirect:afficherUpdateAgence";
		}
	}

	@RequestMapping(value = "/admin/submitDeleteAgence", method = RequestMethod.POST)
	public String soumettreSupprimer(Model model, @ModelAttribute("agDelete") Agence aIn) {
		// Appel de la méthode service
		boolean eOut = agenceService.deleteAgence(aIn.getId());
		if (eOut != false) {
			List<Agence> listeAgences = agenceService.getAllAgence();

			// Mettre à jour la liste
			model.addAttribute("Agences", listeAgences);

			return "redirect:listeAgence";
		} else {
			return "redirect:afficherDeleteAgence";
		}
	}

}
