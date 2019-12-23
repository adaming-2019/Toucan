package fr.adaming.entities;

import java.util.List;

public class ChoixAssurance {
	/**
	 * cette classe permet d'enregistrer la liste des assurances choisies par le client pour un dossier
	 * 
	 */
	
	// déclaration des attributs
	private List<String> choix;

	// déclaration des getters et setters
	public List<String> getChoix() {
		return choix;
	}

	public void setChoix(List<String> choix) {
		this.choix = choix;
	}

	@Override
	public String toString() {
		return "ChoixAssurance [choix=" + choix + "]";
	}
	
	

}
