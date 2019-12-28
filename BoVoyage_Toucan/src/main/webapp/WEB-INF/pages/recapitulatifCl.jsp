<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div>
		<h3>Voyage</h3>
		<p>Destination : ${dossier.destination.pays}</p>
		<br />
		<p>du ${dossier.dateDebut} au ${dossier.dateRetour}</p>
		<br />
		<p>Formule : ${dossier.formule.formule}</p>
		<br />
		<p>Prestation d'h�b�rgement : ${dossier.prestation.prestation}</p>
		<br />
		<p>Prix agence : ${dossier.prixAgence} EUR</p>
		<br />
		<p>Prix BoVoyage : ${dossier.prixBoVoyage} EUR</p>
		<br /> <br />

		<h3>Votre r�servation</h3>
		<p>Nombre de places : ${dossier.dossier.nbPlaces}</p>
		<br />
		<p>Informations sur les passagers :</p>
		<c:forEach var="passager" items="${dossier.voyageurs}">
			<p>${passager.civilite}${passager.nom}${passager.prenom}</p>
			<br />
			<p>Date de naissance : ${passager.dn}</p>
			<br />
			<p>Adresse : ${passager.adresse}</p>
			<br />
			<p>T�l�phone : ${passager.telephone}</p>
			<br />
			<p>Nationalit� : ${passager.nationalite}</p>
			<br />
			<br />
		</c:forEach>

		<p>Vous avez s�l�ctionn� les assurances suivantes :</p>
		<c:forEach var="assurance" items="${dossier.assurances}">
			${assurance.type} (montant : ${assurance.montant} EUR)
			<br />
		</c:forEach>

		<br />
		<p>Prix total : ${total}</p>

		<br />
		<p>Note : votre compte bancaire ne sera d�bit� qu'apr�s
			v�rification par BoVoyage de la validit� de votre num�ro de carte de
			cr�dit.</p>
		<br />

		<form action="validerReservation" method="get">
			<input type="button" value="Valider ma r�servation" />
		</form>

	</div>


</body>
</html>