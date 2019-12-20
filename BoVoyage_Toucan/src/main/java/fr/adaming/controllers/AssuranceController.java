package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
