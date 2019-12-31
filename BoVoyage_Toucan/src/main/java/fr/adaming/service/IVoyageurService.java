package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Voyageur;

public interface IVoyageurService {
	
	public List<Voyageur> getAllVoyageurs();
	
	public Voyageur getVoyageurById(Voyageur eIn);
	
	public Voyageur addVoyageur(Voyageur eIn);
	
	public boolean deleteVoyageur(Voyageur eIn);
	
	public boolean updateVoyageur(Voyageur eIn);
	
	public Voyageur updateVoyageurClient(Voyageur eIn);

}
