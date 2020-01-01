package fr.adaming.entities;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.Set;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FirstPdf {
	private static String FILE = "C:\\Users\\IN-BR-002\\Desktop\\Recaputilatif.pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public static void creerPdf(Destination destination, Date dateDebut, Date dateRetour, Formule formule,
			Prestation prestation, CategorieVehicule categorieVehicule, double prixBoVoyage, int nbPlaces,
			String civilite, String nom, String prenom, String adresse, String telephone, String nationalite, Date dn,
			Set<Assurance> assurances, double total, int id) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addMetaData(document);
			addTitlePage(document, destination, dateDebut, dateRetour, formule, prestation, categorieVehicule,
					prixBoVoyage, nbPlaces, civilite, nom, prenom, adresse, telephone, nationalite, dn, assurances,
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
			int nbPlaces, String civilite, String nom, String prenom, String adresse, String telephone,
			String nationalite, Date dn, Set<Assurance> assurances, double total, int id) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Recapitulatif du voyage r�serv�", catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph("Recapitulatif g�n�r� le : " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				smallBold));
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("D�tail du voyage :   ", smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Destination :  " + destination, smallBold));
		preface.add(new Paragraph("Date d'aller :  " + dateDebut, smallBold));
		preface.add(new Paragraph("Date de retour :  " + dateRetour, smallBold));
		preface.add(new Paragraph("Formule :  " + formule, smallBold));
		preface.add(new Paragraph("Prestation :  " + prestation, smallBold));
		preface.add(new Paragraph("Categorie de vehicule :  " + categorieVehicule, smallBold));
		preface.add(new Paragraph("Prix :  " + prixBoVoyage, smallBold));
		addEmptyLine(preface, 2);

		preface.add(new Paragraph("D�tail des voyageurs :   ", smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Places  :  " + nbPlaces, smallBold));
		preface.add(new Paragraph("Civilite  :  " + civilite, smallBold));
		preface.add(new Paragraph("Nom :  " + nom, smallBold));
		preface.add(new Paragraph("Prenom :  " + prenom, smallBold));
		preface.add(new Paragraph("Adresse :  " + adresse, smallBold));
		preface.add(new Paragraph("Telephone :  " + telephone, smallBold));
		preface.add(new Paragraph("Nationalit�:  " + nationalite, smallBold));
		preface.add(new Paragraph("Date de naissance :  " + dn, smallBold));
		preface.add(new Paragraph("Assurances :  " + assurances, smallBold));

		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Total :  " + total, smallBold));

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