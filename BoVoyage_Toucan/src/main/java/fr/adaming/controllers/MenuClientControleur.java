package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Assurance;
import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IVoyageurService;

@Controller
@RequestMapping("/client")
public class MenuClientControleur {
	
	// déclaration des attributs
	private Client client;
	
	// transformation de l'association uml en java
	@Autowired
	private IDossierService dosService;
	@Autowired
	private IVoyageurService vgService;

	// setters pour l'injection de dépendance
	public void setDosService(IDossierService dosService) {
		this.dosService = dosService;
	}
	
	public void setVgService(IVoyageurService vgService) {
		this.vgService = vgService;
	}


	// méthode pour instancier l'attribut client lors de l'instanciation du controleur
	@PostConstruct
	public void init() {
		this.client = new Client();
		this.client.setId(72);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

	}
	
	// méthodes métiers
	
	// affichage de la liste des dossiers
	@RequestMapping(value="/listeDossiers", method=RequestMethod.GET)
	public String afficheListeDossiers(Model model) {
		// appel de la méthode service
		List<Dossier> listeDossiers = dosService.getAllByClient(this.client);
		
		// associer la liste des dossiers au modele mvc
		model.addAttribute("dossiers", listeDossiers);
		
		return "menuCl";
	}
	
	// affichage des détails du dossier
	@RequestMapping(value="/detailsDossier", method=RequestMethod.GET)
	public String afficheDetailsDossier(Model model, @RequestParam("pIdDossier") int idIn) {
		
		// récupération des données du dossier dans la bd
		Dossier dossier = dosService.getById(idIn);
		
		// récupération de la liste de voyageurs associée au dossier
		List<Voyageur> voyageurs = dossier.getVoyageurs();
		
		// récupération de la liste de assurances associée au dossier
		Set<Assurance> assurances = dossier.getAssurances();
		
		for (Assurance a : assurances) {
			System.out.println(a);
		}
		
		// calcul du prix total payé par le client
		double total = 0;
		
		for (Voyageur v : voyageurs) {
			total += dossier.getVoyage().getPrixBoVoyage();
		}
		
		for (Assurance assurance : assurances) {
			total += assurance.getMontant();
		}
		
		// ajout du dossier récupéré au modele mvc
		model.addAttribute("dossier", dossier);
				
		// ajout de la liste de voyageurs au modele mvc
		model.addAttribute("voyageurs", voyageurs);
		
		// ajout de la liste d'assurances au modele mvc
		model.addAttribute("assurances", assurances);
		
		// ajout du prix total au modele mvc
		model.addAttribute("total", total);
		
		
		return "infosDossierCl";
	}
	
	// afficher le formulaire de modification d'un voyageur
	@RequestMapping(value="/modifVoyageur", method=RequestMethod.GET)
	public String modifierVoyageur(HttpServletRequest req, Model model, @RequestParam(value="pId") Integer idIn) {
		
		// instanciation d'un nouveau voyageur pour lui associer la valeur de pId
		Voyageur vgIn = new Voyageur();
		vgIn.setId(idIn);
		
		// récupérer le voyageur associé à pId
		Voyageur vgModif = vgService.getVoyageurById(vgIn);
		
		// récupérer le dossier lié au voyageur pour l'ajouter dans la session
		Dossier dossier = vgModif.getDossier();
		
		HttpSession maSession = req.getSession();
		
		maSession.setAttribute("dossier", dossier);
		
		// associer le voyageur au modele mvc
		model.addAttribute("voyageur", vgModif);
		
		return "modifierVoyageurCl";
		
	}
	
	// soumettre la modification d'un voyageur
	@RequestMapping(value="/submitModifVoyageur", method=RequestMethod.POST)
	public String soumettreModifVoyageur(HttpServletRequest req, Model model, @ModelAttribute("voyageur") Voyageur vgIn, RedirectAttributes rda) {
		
		System.out.println(vgIn);
		
		// modifier le voyageur dans la bd
		vgService.updateVoyageurClient(vgIn);
		
		// on redirige le client vers la page du dossier en cours, pour cela on ajoute l'id du dossier au RedirectAttributes
		// récupération du dossier dans la session
		HttpSession maSession = req.getSession();
			
		Dossier dossier = (Dossier) maSession.getAttribute("dossier");
			
		rda.addAttribute("pIdDossier", dossier.getId());
			
		// supprimer le dossier de la session
		maSession.removeAttribute("dossier");
			
		return "redirect:detailsDossier";
		
	}

}
