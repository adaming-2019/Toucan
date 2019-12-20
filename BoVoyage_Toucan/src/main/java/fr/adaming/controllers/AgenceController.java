package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
