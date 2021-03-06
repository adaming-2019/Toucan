<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D�tails du dossier</title>

<!-- Lier la librairie bootstrap � ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

<script src="<c:url value='/assets/js/BoVoyageJs.js' />"></script>

</head>
<body>

	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>

	<div class="formulaire">

		<h2 id="titre">D�tails du dossier</h2>
		<h3 style="color: darkblue">Voyage</h3>
		<p>
			<b><span> Destination :</span></b> ${dossier.voyage.destination.pays}
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

		<h3 style="color: darkblue">Votre r�servation</h3>
		<p>
			<b><span>Nombre de places :</span></b> ${dossier.nbPlaces}
		</p>
		<br />
		<p>
			<b><span>Informations sur les passagers :</span></b>
		</p>
		<c:forEach var="passager" items="${voyageurs}">
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
				<br /> <a class="btn btn-info"
					href="<c:url value='/client/modifVoyageur?pId=${passager.id}'/>">Modifier</a>
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

		<p>
			<b><span><a
					href="<c:url value='/client/PDF?pIdDossier=${dossier.id}'/>">T�l�charger
						un recapitulatif (format PDF)</a></span></b>
		</p>

		<button type="button" class="btn btn-danger"
			onclick="confirmerAnnulation();" style="margin-bottom: 10px;">Annuler
			la r�servation</button>

		<div id="message" class="alert alert-danger alert-dismissible"
			role="alert" style="display: none;">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close" onclick="retourAnnulation();">
				<span aria-hidden="true">&times;</span>
			</button>
			Etes-vous s�r de vouloir annuler cette r�servation ? <a
				href="annulerReservation?pId=${dossier.id}" class="alert-link">Oui</a>
		</div>

	</div>

	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>
</body>
</html>