package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginAdmController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String afficheFormLogin() {
		return "login";
	}

	@RequestMapping(value = "/admin/connexionAdm", method = RequestMethod.POST)
	public String afficheAcueilAdm() {
		return "accueilAdm";
	}

	@RequestMapping(value = "/echec", method = RequestMethod.GET)
	public String echecLogin(Model model) {
		model.addAttribute("msg", "Identifiants incorrects");

		return "login";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String afficheDenied(Model model) {
		model.addAttribute("msg", "Vous n'êtes pas autorisé(e) à accéder à cet espace");

		return "redirect:public/afficheListeContinents";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String afficheLogout(Model model) {
		model.addAttribute("msg", "Vous êtes déconnecté(e)");

		return "redirect:public/afficheListeContinents";
	}

}
