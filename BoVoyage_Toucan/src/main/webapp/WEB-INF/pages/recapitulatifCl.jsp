<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>R�capitulatif de votre dossier</title>
<!-- Lier lb bootstrap � ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>

	<h2 id="titre">R�capitulatif de votre commande</h2>
	<div class="formulaire">
		<h3>Voyage</h3>
		<p>
			<b><span>Destination :</span></b> ${dossier.voyage.destination.pays}
		</p>
		<br />
		<p>du ${dossier.voyage.dateDebut} au ${dossier.voyage.dateRetour}</p>
		<br />
		<p>
			<b><span>Formule :</span></b> ${dossier.voyage.formule.formule}
		</p>
		<br />
		<c:if test="${not empty dossier.voyage.prestation}">
			<p>
				<b><span>Prestation d'h�b�rgement :</span></b>
				${dossier.voyage.prestation.prestation}
			</p>
			<br />
		</c:if>

		<c:if test="${not empty dossier.voyage.categorieVehicule}">
			<p>
				<b><span>Cat�gorie de v�hicule :</span></b>
				${dossier.voyage.categorieVehicule.categorieVehicule}
			</p>
			<br />
		</c:if>

		<p>
			<b><span>Prix agence :</span></b> ${dossier.voyage.prixAgence} EUR
			par personne
		</p>
		<br />
		<p>
			<b><span>Prix BoVoyage :</span></b> ${dossier.voyage.prixBoVoyage}
			EUR par personne
		</p>
		<br /> <br />

		<h3>Votre r�servation</h3>
		<p>
			<b><span>Nombre de places :</span></b> ${dossier.nbPlaces}
		</p>
		<br />
		<p>
			<b><span>Informations sur les passagers :</span></b>
		</p>
		<c:forEach var="passager" items="${dossier.voyageurs}">
			<div class="encadre">
				<p>${passager.civilite}.${passager.nom}${passager.prenom}</p>
				<br />
				<p>
					<b><span>Date de naissance :</span></b> ${passager.dn}
				</p>
				<br />
				<p>
					<b><span>Adresse :</span></b> ${passager.adresse}
				</p>
				<br />
				<p>
					<b><span>T�l�phone :</span></b> ${passager.telephone}
				</p>
				<br />
				<p>
					<b><span>Nationalit� :</span></b> ${passager.nationalite}
				</p>
				<br />
			</div>
		</c:forEach>

		<c:if test="${not empty assurances}">
			<p>
				<b><span>Vous avez s�l�ctionn� les assurances suivantes :</span></b>
			</p>
			<c:forEach var="assurance" items="${assurances}">
			${assurance.type} (montant : ${assurance.montant} EUR)
			<br />
			</c:forEach>
		</c:if>

		<c:if test="${empty assurances}">
			<p>Vous n'avez s�lectionn� aucune assurance pour ce voyage.</p>
		</c:if>

		<br />
		<p>
			<b><span>Prix total :</span></b> ${total} EUR
		</p>

		<br />
		<p>
			<b><span>Note :</span></b> votre compte bancaire ne sera d�bit�
			qu'apr�s v�rification par BoVoyage de la validit� de votre num�ro de
			carte de cr�dit.
		</p>
		<br />

		<form action="validerReservation" method="get">
			<button class="btn btn-success">Valider ma r�servation</button>
		</form>

	</div>

	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>


</body>
</html>