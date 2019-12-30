package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IDossierService;

@Controller
@RequestMapping("/admin")
public class DossierController {

	//transformation de l'association UML en java
	@Autowired
	private IDossierService dservices;
	
	//setter pour l'injection de dépendance 
	public void setDservices(IDossierService dservices) {
		this.dservices = dservices;
	}
	
	
	//développement des méthodes 
	//afficher la liste des dossiers 
	@RequestMapping(value = "/listeDossiers", method = RequestMethod.GET)
	public ModelAndView afficherDossiers() {
		//récupérer liste dossiers 
		List<Dossier> listeDossiers=dservices.getAllDossier();
		return new ModelAndView("listeDossierAdm", "dossiers", listeDossiers);	
	}
	
	//méthode modifier un dossier 
	@RequestMapping(value="/modifDossier", method=RequestMethod.GET)
	public String modifierDossier() {
		return "modifierDossierAdm";	
	}
	@RequestMapping(value="/updateDossier", method=RequestMethod.POST)
	public String updateDossier(RedirectAttributes rda, Model modele,@RequestParam("pId") int dossierIn) {
		
		Dossier dIn=new Dossier();
		dIn.setId(dossierIn);
		
		boolean verif=dservices.updateDossier(dIn);
		if(verif){
			return "redirect:listeDossiers";
		}else {
			rda.addFlashAttribute("msg", "le dossier a modifier n'existe pas");
			return "redirect:modifDossier";
		}
	}
	
	//Méthode supprimer un dossier 
	@RequestMapping(value="/suppDossier", method=RequestMethod.GET)
	public String supprimerDossier () {
		return "supprimerDossierAdm";
	}
	
	@RequestMapping(value="/deleteDossier", method=RequestMethod.POST)
	public String deleteDossier(RedirectAttributes rda, @RequestParam("pId") int idIn) {

		Dossier dossierIn = new Dossier();
		dossierIn.setId(idIn);

		boolean verif = dservices.deleteDossier(idIn);
		if (verif) {
			return "redirect:listeDossiers";
		} else {
			// l'objet RedirectAttributes sert à transporter les attributs du
			// modele mvc lors de la redirection
			rda.addFlashAttribute("msg", "Le dossier a supprimer n'existe pas");
			return "redirect:deleteDossier";
		}

	}
}
