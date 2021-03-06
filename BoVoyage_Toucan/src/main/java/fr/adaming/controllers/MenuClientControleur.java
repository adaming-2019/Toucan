package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	// d�claration des attributs
	private Client client;
	
	// transformation de l'association uml en java
	@Autowired
	private IDossierService dosService;
	@Autowired
	private IVoyageurService vgService;

	// setters pour l'injection de d�pendance
	public void setDosService(IDossierService dosService) {
		this.dosService = dosService;
	}
	
	public void setVgService(IVoyageurService vgService) {
		this.vgService = vgService;
	}


	// m�thode pour instancier l'attribut client lors de l'instanciation du controleur
	@PostConstruct
	public void init() {
		this.client = new Client();
		this.client.setId(1);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

	}
	
	// m�thodes m�tiers
	
	// affichage de la liste des dossiers
	@RequestMapping(value="/listeDossiers", method=RequestMethod.GET)
	public String afficheListeDossiers(Model model) {
		// appel de la m�thode service
		List<Dossier> listeDossiers = dosService.getAllByClient(this.client);
		
		// associer la liste des dossiers au modele mvc
		model.addAttribute("dossiers", listeDossiers);
		
		return "menuCl";
	}
	
	// affichage des d�tails du dossier
	@RequestMapping(value="/detailsDossier", method=RequestMethod.GET)
	public String afficheDetailsDossier(Model model, @RequestParam("pIdDossier") int idIn) {
		
		// r�cup�ration des donn�es du dossier dans la bd
		Dossier dossier = dosService.getById(idIn);
		
		// r�cup�ration de la liste de voyageurs associ�e au dossier
		List<Voyageur> voyageurs = dossier.getVoyageurs();
		
		// r�cup�ration de la liste de assurances associ�e au dossier
		Set<Assurance> assurances = dossier.getAssurances();
		
		for (Assurance a : assurances) {
			System.out.println(a);
		}
		
		// calcul du prix total pay� par le client
		double total = 0;
		
		for (Voyageur v : voyageurs) {
			total += dossier.getVoyage().getPrixBoVoyage();
		}
		
		for (Assurance assurance : assurances) {
			total += assurance.getMontant();
		}
		
		// ajout du dossier r�cup�r� au modele mvc
		model.addAttribute("dossier", dossier);
				
		// ajout de la liste de voyageurs au modele mvc
		model.addAttribute("voyageurs", voyageurs);
		
		// ajout de la liste d'assurances au modele mvc
		List<Assurance> listeAssurances = new ArrayList<Assurance>();
		for (Assurance a : assurances) {
			listeAssurances.add(a);
		}
		
		model.addAttribute("assurances", listeAssurances);
		
		// ajout du prix total au modele mvc
		model.addAttribute("total", total);
		
		
		return "infosDossierCl";
	}
	
	// afficher le formulaire de modification d'un voyageur
	@RequestMapping(value="/modifVoyageur", method=RequestMethod.GET)
	public String modifierVoyageur(Model model, @RequestParam(value="pId") Integer idIn) {
		
		// instanciation d'un nouveau voyageur pour lui associer la valeur de pId
		Voyageur vgIn = new Voyageur();
		vgIn.setId(idIn);
		
		// r�cup�rer le voyageur associ� � pId
		Voyageur vgModif = vgService.getVoyageurById(vgIn);
		
		// associer le voyageur au modele mvc
		model.addAttribute("voyageur", vgModif);
		
		return "modifierVoyageurCl";
		
	}
	
	// soumettre la modification d'un voyageur
	@RequestMapping(value="/submitModifVoyageur", method=RequestMethod.POST)
	public String soumettreModifVoyageur(Model model, @ModelAttribute("voyageur") Voyageur vgIn, RedirectAttributes rda) {
		
		System.out.println(vgIn);
		
		// modifier le voyageur dans la bd
		vgService.updateVoyageurClient(vgIn);
		
		// on redirige le client vers la page du dossier en cours, pour cela on ajoute l'id du dossier au RedirectAttributes	
		rda.addAttribute("pIdDossier", vgIn.getDossier().getId());
			
		return "redirect:detailsDossier";
		
	}
	
	@RequestMapping(value="/annulerReservation", method=RequestMethod.GET)
	public String annulerReservation(Model model, @RequestParam(value="pId") Integer idDossier) {
		// d�finier le statut du dossier sur "annule"
		Dossier dossier = dosService.getById(idDossier);
		
		dossier.setEtat("annule");
		
		dosService.updateDossier(dossier);
		
		return "redirect:listeDossiers";
	}

}
