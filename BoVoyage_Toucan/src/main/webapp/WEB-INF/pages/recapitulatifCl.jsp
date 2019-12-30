<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Récapitulatif de votre dossier</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>

	<h2 id="titre">Récapitulatif de votre commande</h2>
	<div>
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
				<b><span>Prestation d'hébérgement :</span></b>
				${dossier.voyage.prestation.prestation}
			</p>
			<br />
		</c:if>
		<p>
			<b><span>Prix agence :</span></b> ${dossier.voyage.prixAgence} EUR
		</p>
		<br />
		<p>
			<b><span>Prix BoVoyage :</span></b> ${dossier.voyage.prixBoVoyage}
			EUR
		</p>
		<br /> <br />

		<h3>Votre réservation</h3>
		<p>
			<b><span>Nombre de places :</span></b> ${dossier.nbPlaces}
		</p>
		<br />
		<p>
			<b><span>Informations sur les passagers :</span></b>
		</p>
		<c:forEach var="passager" items="${dossier.voyageurs}">
			<p>${passager.civilite}.${passager.nom} ${passager.prenom}</p>
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
				<b><span>Téléphone :</span></b> ${passager.telephone}
			</p>
			<br />
			<p>
				<b><span>Nationalité :</span></b> ${passager.nationalite}
			</p>
			<br />
			<br />
		</c:forEach>

		<p>
			<b><span>Vous avez séléctionné les assurances suivantes :</span></b>
		</p>
		<c:forEach var="assurance" items="${dossier.assurances}">
			${assurance.type} (montant : ${assurance.montant} EUR)
			<br />
		</c:forEach>

		<br />
		<p>
			<b><span>Prix total :</span></b> ${total} EUR
		</p>

		<br />
		<p>
			<b><span>Note :</span></b> votre compte bancaire ne sera débité
			qu'après vérification par BoVoyage de la validité de votre numéro de
			carte de crédit.
		</p>
		<br />

		<form action="validerReservation" method="get">
			<button class="btn btn-success" >Valider ma réservation</button>
		</form>

	</div>
	
	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>


</body>
</html>