package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Voyageur;
import fr.adaming.service.IVoyageurService;

@Controller
@RequestMapping("/admin")
public class VoyageurController {

	// transformation UML en java
	@Autowired
	private IVoyageurService vrService;

	// setter pour l'injection de d�pendance
	public void setVrService(IVoyageurService vrService) {
		this.vrService = vrService;
	}

	// convertir les valeurs des param�tres en objet java (ici la date de naissance)
	public void initBinder(WebDataBinder binder) {
		// l'objet web databinder sert � faire le lien entre les params de la requete et
		// les objets java.
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		// la m�thode registerCustomEditor() :sert � configuer la conversion du
		// param�tre re�u
		// l'objet CustomDateEditor : sert � lier la date re�ue comme param�tre
		// de la requ�te � l'attribut de l'objet �tudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// d�veloppement des m�thodes.
	// afficher la liste des voyageurs
	@RequestMapping(value = "/listeVoyageurs", method = RequestMethod.GET)
	public ModelAndView afficheListeVoyageurs() {
		// r�cup�rer la liste des voyageurs
		List<Voyageur> listeVoyageur = vrService.getAllVoyageurs();
		return new ModelAndView("listeVoyageursAdm", "voyageurs", listeVoyageur);
	}

	// formulaire de suppression d'un voyageur.
	@RequestMapping(value = "/deleteVoyageur", method = RequestMethod.GET)
	public String supprimerVoyageur() {
		return "supprimerVoyageurAdm";
	}

	@RequestMapping(value = "/submitVoyageur", method = RequestMethod.GET)
	public String afficherVoyageur(RedirectAttributes rda, @RequestParam("pId") int idIn) {

		Voyageur vIn = new Voyageur();
		vIn.setId(idIn);

		boolean verif = vrService.deleteVoyageur(vIn);
		if (verif) {
			return "redirect:listeVoyageurs";
		} else {
			// l'objet RedirectAttributes sert � transporter les attributs du
			// modele mvc lors de la redirection
			rda.addFlashAttribute("msg", "Le voyageur n'existe pas");
			return "redirect:deleteVoyageur";
		}

	}

	// formulaire de modification d'un voyageur
	@RequestMapping(value = "/modifVoyageur", method = RequestMethod.GET)
	public ModelAndView modifierVoyageur() {
		return new ModelAndView("modifierVoyageurAdm", "vgrModif", new Voyageur());
	}

	@RequestMapping(value = "/updateVoyageur", method = RequestMethod.POST)
	public String updateVoyageur(RedirectAttributes rda, Model modele, @ModelAttribute("vgrModif") Voyageur eIn) {

		boolean verif = vrService.updateVoyageur(eIn);
		if (verif) {
			return "redirect:listeVoyageurs";
		} else {
			// l'objet RedirectAttributes sert � transporter les attributs du
			// modele mvc lors de la redirection
			rda.addFlashAttribute("msg", "Le voyageur � modifier n'existe pas");
			return "redirect:modifVoyageur";
		}
	}

	// lien pour modifier un voyageur
	@RequestMapping(value = "/linkUpdateVoyageur", method = RequestMethod.GET)
	public String getModifLien(Model modele, @RequestParam("pId") int id) {
		 Voyageur vIn=new Voyageur();
		 vIn.setId(id);
		Voyageur vOut = vrService.getVoyageurById(vIn);

		modele.addAttribute("vgrModif", vOut);

		return "modifierVoyageurAdm";
	}
}
