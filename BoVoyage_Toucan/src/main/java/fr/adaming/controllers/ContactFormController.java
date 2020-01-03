package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Contact;
import fr.adaming.service.IMailConfig;

@Controller
@RequestMapping("/public")
public class ContactFormController {

	@Autowired
	public IMailConfig mailService;

	// Affichage du formulaire de contact
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView afficherForm(@ModelAttribute("contact") Contact c) {
		if (c == null) {
			c = new Contact();
		}
		return new ModelAndView("contact", "contact", c);
	}

	// Envoyer un mail
	@RequestMapping(value = "/sendSimpleEmail", method = RequestMethod.POST)
	public String sendSimpleEmail(RedirectAttributes rda, Model model, @ModelAttribute("contact") Contact c) {

		// idealement il faudrait envoyer le mail à un conseiller
		mailService.sendMail("emilie.lepeltier@yahoo.fr", " Vous avez recu un message de " + c.getName() + " ( email: "
				+ c.getEmail() + " )" + System.getProperty("line.separator") + c.getText(), c.getSubject());
		// Redirection vers la page
		rda.addFlashAttribute("successMsg", "Mail sent");
		return "redirect:/afficheListeContinent";

	}

}
