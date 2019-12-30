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
<title>Informations voyageurs</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>

	<h2 style="color: darkBlue; text-align: center">Veuillez saisir
		les informations du voyageur numéro ${noVoyageur}</h2>

	<form:form action="submitSaisieVoyageur" method="POST"
		modelAttribute="voyageur">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idCivilite">Civilite</label>
			<div class="col-sm-2">
				<form:input path="civilite" type="text" class="form-control"
					id="idCivilite" placeholder="Civilite" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idNom">Nom</label>
			<div class="col-sm-2">
				<form:input path="nom" type="text" class="form-control" id="idNom"
					placeholder="Nom" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPrenom">Prenom</label>
			<div class="col-sm-2">
				<form:input path="prenom" type="text" class="form-control"
					id="idPrenom" placeholder="Prenom" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idDn">Date de
				naissance</label>
			<div class="col-sm-2">
				<form:input path="dn" type="date" class="form-control" id="idDn" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idAdresse">Adresse</label>
			<div class="col-sm-2">
				<form:input path="adresse" type="text" class="form-control"
					id="idAdresse" placeholder="Adresse" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idTel">Telephone</label>
			<div class="col-sm-2">
				<form:input path="telephone" type="text" class="form-control"
					id="idTel" placeholder="Telephone" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idNationalite">Nationalite</label>
			<div class="col-sm-2">
				<form:input path="nationalite" type="text" class="form-control"
					id="idNationalite" placeholder="Nationalite" />
			</div>
			<div class="col-sm-3">
				<input class="btn btn-primary" type="submit" value="Continuer" />
			</div>
		</div>
		<%-- Civilité : <form:input path="civilite" />
		<br />
		Nom : <form:input path="nom" />
		<br />
		Prénom : <form:input path="prenom" />
		<br />
		Date de naissance : <form:input type="date" path="dn" />
		<br />
		Adresse : <form:input path="adresse" />
		<br />
		Téléphone : <form:input path="telephone" />
		<br />
		Nationalité : <form:input path="nationalite" />
		<br />
		<input type="submit" value="Continuer" /> --%>
	</form:form>

</body>
</html>