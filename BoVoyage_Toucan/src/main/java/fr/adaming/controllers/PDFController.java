package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.entities.Assurance;
import fr.adaming.entities.Client;
import fr.adaming.entities.Dossier;
import fr.adaming.entities.FirstPdf;
import fr.adaming.entities.Voyageur;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IVoyageurService;

@Controller
@RequestMapping("/client")
public class PDFController {

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

	// méthode pour instancier l'attribut client lors de l'instanciation du
	// controleur
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

	// méthodes métiers

	// affichage des détails du dossier
	@RequestMapping(value = "/PDF", method = RequestMethod.GET)
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
		List<Assurance> listeAssurances = new ArrayList<Assurance>();
		for (Assurance a : assurances) {
			listeAssurances.add(a);
		}

		model.addAttribute("assurances", listeAssurances);

		// ajout du prix total au modele mvc
		model.addAttribute("total", total);

		FirstPdf.creerPdf(dossier.getVoyage().getDestination(), dossier.getVoyage().getDateDebut(),
				dossier.getVoyage().getDateRetour(), dossier.getVoyage().getFormule(),
				dossier.getVoyage().getPrestation(), dossier.getVoyage().getCategorieVehicule(),
				dossier.getVoyage().getPrixBoVoyage(), dossier.getNbPlaces(), dossier.getClient().getCivilite(),
				dossier.getClient().getNom(), dossier.getClient().getPrenom(), dossier.getClient().getAdresse(),
				dossier.getClient().getTelephone(), dossier.getClient().getNationalite(), dossier.getClient().getDn(),
				dossier.getAssurances(), total);

		return "infosDossierCl";
	}

}
