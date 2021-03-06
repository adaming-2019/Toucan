package fr.adaming.entities;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FirstPdf {
	private static String FILE = "C:\\Users\\IN-BR-004\\Desktop\\Recapitulatif.pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public static void creerPdf(Destination destination, Date dateDebut, Date dateRetour, Formule formule,
			Prestation prestation, CategorieVehicule categorieVehicule, double prixBoVoyage, int nbPlaces,
			List<Voyageur> voyageurs, Set<Assurance> assurances, double total, int id) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addMetaData(document);
			addTitlePage(document, destination, dateDebut, dateRetour, formule, prestation, categorieVehicule,
					prixBoVoyage, nbPlaces, voyageurs, assurances,
					total, id);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document) {
		document.addTitle("My first PDF");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("LEPELTIER Emilie");
		document.addCreator("LEPELTIER Emilie");
	}

	private static void addTitlePage(Document document, Destination destination, Date dateDebut, Date dateRetour,
			Formule formule, Prestation prestation, CategorieVehicule categorieVehicule, double prixBoVoyage,
			int nbPlaces, List<Voyageur> voyageurs, Set<Assurance> assurances, double total, int id) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Recapitulatif du voyage r�serv�", catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph("Recapitulatif g�n�r� par " + System.getProperty("user.name") + ", le " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				smallBold));
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("D�tails du voyage :   ", smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Destination :  " + destination.getPays() + " (" + destination.getContinent() + ")", smallBold));
		preface.add(new Paragraph("Date d'aller :  " + dateDebut, smallBold));
		preface.add(new Paragraph("Date de retour :  " + dateRetour, smallBold));
		if (formule!=null) {
			preface.add(new Paragraph("Formule :  " + formule.getFormule(), smallBold));
		}
		if (prestation!=null) {
			preface.add(new Paragraph("Prestation :  " + prestation.getPrestation(), smallBold));
		}
		if(categorieVehicule!=null) {
			preface.add(new Paragraph("Categorie de vehicule :  " + categorieVehicule.getCategorieVehicule(), smallBold));
		}
		
		preface.add(new Paragraph("Prix BoVoyage :  " + prixBoVoyage + "�", smallBold));
		addEmptyLine(preface, 2);

		preface.add(new Paragraph("Nombre de places r�serv�es  :  " + nbPlaces, smallBold));
		preface.add(new Paragraph("D�tail des voyageurs :   ", smallBold));
		addEmptyLine(preface, 1);
		
		int compteur = 0;
		
		for (Voyageur v:voyageurs) {
			compteur++;
			preface.add(new Paragraph("Voyageur n�"+compteur, smallBold));
			preface.add(new Paragraph("Civilit�  :  " + v.getCivilite(), smallBold));
			preface.add(new Paragraph("Nom :  " + v.getNom(), smallBold));
			preface.add(new Paragraph("Pr�nom :  " + v.getPrenom(), smallBold));
			preface.add(new Paragraph("Adresse :  " + v.getAdresse(), smallBold));
			preface.add(new Paragraph("T�l�phone :  " + v.getTelephone(), smallBold));
			preface.add(new Paragraph("Date de naissance :  " + v.getDn(), smallBold));
			preface.add(new Paragraph("Nationalit�:  " + v.getNationalite(), smallBold));
			addEmptyLine(preface, 1);
			
		}
		
		if (assurances.equals(null)) {
			preface.add(new Paragraph("Vous n'avez souscrit aucune assurance pour ce voyage :", smallBold));
		}
		
		if (!assurances.equals(null)) {
			preface.add(new Paragraph("Vous avez souscrit la(les) assurance(s) suivante(s) pour ce voyage :", smallBold));
			addEmptyLine(preface, 1);
			
			for (Assurance a:assurances) {
				preface.add(new Paragraph(a.getType() + " (" + a.getMontant() + "�)", smallBold));
			}
		}
		
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Total :  " + total + "�", smallBold));

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}