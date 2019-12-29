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

</head>
<body>

	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	
	<h2 id="titre">D�tails du dossier</h2>
		<h3>Voyage</h3>
		<p>Destination : ${dossier.voyage.destination.pays}</p>
		<br />
		<p>du ${dossier.voyage.dateDebut} au ${dossier.voyage.dateRetour}</p>
		<br />
		<p>Formule : ${dossier.voyage.formule.formule}</p>
		<br />
		<c:if test="${not empty dossier.voyage.prestation}">
		<p>Prestation d'h�b�rgement : ${dossier.voyage.prestation.prestation}</p>
		<br />
		</c:if>
		<p>Prix agence : ${dossier.voyage.prixAgence} EUR</p>
		<br />
		<p>Prix BoVoyage : ${dossier.voyage.prixBoVoyage} EUR</p>
		<br /> <br />

		<h3>Votre r�servation</h3>
		<p>Nombre de places : ${dossier.nbPlaces}</p>
		<br />
		<p>Informations sur les passagers :</p>
		<c:forEach var="passager" items="${voyageurs}">
			<p>${passager.civilite}. ${passager.nom} ${passager.prenom}</p>
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
		<p>Prix total : ${total} EUR</p>

</body>
</html>