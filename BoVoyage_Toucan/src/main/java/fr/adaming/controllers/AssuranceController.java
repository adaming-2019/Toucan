package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Agence;
import fr.adaming.entities.Assurance;
import fr.adaming.entities.Assurance;
import fr.adaming.entities.Assurance;
import fr.adaming.entities.Assurance;
import fr.adaming.service.IAssuranceService;

@Controller
public class AssuranceController {
	// Transformation de l'association uml en java
	@Autowired
	private IAssuranceService AssuranceService;

	// Le setter pour l'injection dépendance
	public void setAssuranceService(IAssuranceService AssuranceService) {
		this.AssuranceService = AssuranceService;
	}

	@RequestMapping(value = "/admin/listeAssurance", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// recup de la liste des Assurance du formateur
		List<Assurance> listeAssurance = AssuranceService.getAllAssurances();
		return new ModelAndView("listeAssuranceAdm", "assurances", listeAssurance);
	}

	@RequestMapping(value = "/admin/afficherAddAssurance", method = RequestMethod.GET)
	public String afficheAjouter(Model model) {
		model.addAttribute("asAdd", new Assurance());
		return "ajouterAssuranceAdm";
	}

	@RequestMapping(value = "/admin/submitAddAssurance", method = RequestMethod.POST)
	public String soumettreAjouter(Model model, @ModelAttribute("asAdd") Assurance aIn) {
		// Appel de la méthode service
		Assurance eOut = AssuranceService.addAssurance(aIn);
		if (eOut.getId() != 0) {
			List<Assurance> listeAssurances = AssuranceService.getAllAssurances();

			// Mettre à jour la liste
			model.addAttribute("Assurances", listeAssurances);

			return "redirect:listeAssurance";
		} else {
			return "redirect:afficherAddAssurance";
		}
	}

	@RequestMapping(value = "/admin/afficherUpdateAssurance", method = RequestMethod.GET)
	public String afficheModifier(Model model) {
		model.addAttribute("asUpdate", new Assurance());
		return "modifierAssuranceAdm";
	}

	@RequestMapping(value = "/admin/submitUpdateAssurance", method = RequestMethod.POST)
	public String soumettreModifier(Model model, @ModelAttribute("asUpdate") Assurance aIn) {
		// Appel de la méthode service
		Assurance eOut = AssuranceService.update(aIn);
		if (eOut.getId() != 0) {
			List<Assurance> listeAssurances = AssuranceService.getAllAssurances();

			// Mettre à jour la liste
			model.addAttribute("Assurances", listeAssurances);

			return "redirect:listeAssurance";
		} else {
			return "redirect:afficherUpdateAssurance";
		}
	}

	// Lien pour modif
	@RequestMapping(value = "/admin/linkUpdateAssurance", method = RequestMethod.GET)
	public String getModifLien(Model modele, @RequestParam("pId") int idIn) {

		Assurance aOut = AssuranceService.getById(idIn);

		modele.addAttribute("asUpdate", aOut);

		return "modifierAssuranceAdm";

	}

	@RequestMapping(value = "/admin/afficherDeleteAssurance", method = RequestMethod.GET)
	public String afficheSuppprimer(Model model) {
		model.addAttribute("asDelete", new Assurance());
		return "modifierAssuranceAdm";
	}

	@RequestMapping(value = "/admin/submitDeleteAssurance", method = RequestMethod.GET)
	public String soumettreSupprimer(Model model, @ModelAttribute("asDelete") Assurance aIn) {
		// Appel de la méthode service
		boolean eOut = AssuranceService.deleteAssurance(aIn.getId());
		if (eOut != false) {
			List<Assurance> listeAssurances = AssuranceService.getAllAssurances();

			// Mettre à jour la liste
			model.addAttribute("Assurances", listeAssurances);

			return "redirect:listeAssurance";
		} else {
			return "redirect:afficherDeleteAssurance";
		}
	}

}
