package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Formule;

public interface IFormuleService {

	public List<Formule> getall();

	public Formule getById(int fId);

	public Formule add(Formule fId);

	public Formule update(Formule fId);

	public void delete(Formule id);

}
