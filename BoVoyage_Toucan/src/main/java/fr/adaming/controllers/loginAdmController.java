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
		model.addAttribute("msg", "Vous n'�tes pas autoris�(e) � acc�der � cet espace");

		return "redirect:public/afficheListeContinents";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String afficheLogout(Model model) {
		model.addAttribute("msg", "Vous �tes d�connect�(e)");

		return "redirect:public/afficheListeContinents";
	}

}
