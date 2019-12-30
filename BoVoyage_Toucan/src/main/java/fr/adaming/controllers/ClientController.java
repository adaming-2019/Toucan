package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Client;
import fr.adaming.service.IClientService;

@Controller
public class ClientController {
	// Transformation de l'association uml en java
	@Autowired
	private IClientService clientService;

	// Setter pour injection dépendance
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// WebDataBinder permet de faire le lien entre les params et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

	}

	@RequestMapping(value = "/admin/listeClient", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// recup de la liste des Clients
		List<Client> listeClients = clientService.getAllClients();

		System.out.println(listeClients);

		/**
		 * String example = "This is an example"; byte[] bytes = example.getBytes();
		 * 
		 * System.out.println("Text : " + example); System.out.println("Text [Byte
		 * Format] : " + bytes); System.out.println("Text [Byte Format] : " +
		 * bytes.toString());
		 * 
		 * String s = new String(bytes); System.out.println("Text Decryted : " + s);
		 * 
		 * Iterator iterator = listeClients.iterator(); while(iterator.hasNext()) {
		 * System.out.println(iterator.next()+"\n\n"); }
		 **/

		return new ModelAndView("listeClientAdm", "clients", listeClients);
	}

	@RequestMapping(value = "/admin/afficherAddClient", method = RequestMethod.GET)
	public String afficheAjouter(Model model) {
		model.addAttribute("clientAdd", new Client());
		return "ajouterClientAdm";
	}

	@RequestMapping(value = "/admin/submitAddClient", method = RequestMethod.POST)
	public String soumettreAjouter(Model model, @ModelAttribute("clientAdd") Client ClientIn) {
		// Appel de la méthode service
		Client cOut = clientService.addClient(ClientIn);
		if (cOut.getId() != 0) {
			List<Client> listeClients = clientService.getAllClients();

			// Mettre à jour la liste
			model.addAttribute("clients", listeClients);

			return "redirect:listeClient";
		} else {
			return "redirect:afficherAddClient";
		}
	}

	@RequestMapping(value = "/public/afficherCreateAccount", method = RequestMethod.GET)
	public String showAjouterCompte(Model model) {
		model.addAttribute("compteAdd", new Client());
		return "creerCompte";
	}

	@RequestMapping(value = "/public/submitCreateAccount", method = RequestMethod.POST)
	public String AjouterCompte(Model model, @ModelAttribute("compteAdd") Client ClientIn) {
		// Appel de la méthode service
		Client cOut = clientService.addClient(ClientIn);
		if (cOut.getId() != 0) {
			List<Client> listeClients = clientService.getAllClients();

			// Mettre à jour la listes
			model.addAttribute("clients", listeClients);

			return "redirect:afficheListeContinent";
		} else {
			return "redirect:creerCompte";
		}
	}

	@RequestMapping(value = "/admin/afficherUpdateClient", method = RequestMethod.GET)
	public ModelAndView afficheModifier() {
		return new ModelAndView("modifierClientAdm", "cUpdate", new Client());
	}

	@RequestMapping(value = "/admin/submitUpdateClient", method = RequestMethod.POST)
	public String soumettreModifier(Model model, @ModelAttribute("cUpdate") Client ClientIn) {
		// Appel de la méthode service
		Client cOut = clientService.updateClient(ClientIn);
		if (cOut != null) {
			return "redirect:listeClient";
		} else {
			return "redirect:afficherUpdateClient";
		}
	}

	/**
	 * @RequestMapping(value = "/admin/afficherDeleteClient", method =
	 *                       RequestMethod.GET) public String afficheSupprimer(Model
	 *                       model) { model.addAttribute("ClientDelete", new
	 *                       Client()); return "modifierClientAdm"; }
	 * 
	 * @RequestMapping(value = "/admin/submitDeleteClient", method =
	 *                       RequestMethod.POST) public String
	 *                       soumettreSupprimer(Model
	 *                       model, @ModelAttribute("ClientDelete") Client
	 *                       ClientIn, @RequestParam("pId") int idIn) { // Appel de
	 *                       la méthode service boolean eOut =
	 *                       ClientService.deleteClient(idIn); if (eOut != false) {
	 *                       List<Client> listeClients =
	 *                       ClientService.getAllClients();
	 * 
	 *                       // Mettre à jour la liste model.addAttribute("Clients",
	 *                       listeClients);
	 * 
	 *                       return "redirect:listeClient"; } else { return
	 *                       "redirect:afficherDeleteClient"; } }
	 **/

	@RequestMapping(value = "/admin/afficherDeleteClient", method = RequestMethod.GET)
	public String afficheSupprimer() {
		return "modifierClientAdm";
	}

	@RequestMapping(value = "/admin/submitDeleteClient", method = RequestMethod.GET)
	public String soumettreSupprimer(RedirectAttributes rda, @RequestParam("pId") int idIn) {

		// Appel de la méthode service
		boolean cOut = clientService.deleteClient(idIn);
		if (cOut != false) {
			return "redirect:listeClient";
		} else {
			return "redirect:afficherDeleteClient";
		}
	}

	// Lien pour modif
	@RequestMapping(value = "/admin/linkUpdateClient", method = RequestMethod.GET)
	public String getModifLien(Model modele, @RequestParam("pId") int idIn) {

		Client cOut = clientService.getClientById(idIn);

		modele.addAttribute("cUpdate", cOut);

		return "modifierClientAdm";

	}
	

}
