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
		
	<div class="formulaire">

	<form:form action="submitSaisieVoyageur" method="POST"
		modelAttribute="voyageur">
		<div class="form-group">
			<label class="control-label col-sm-3" for="idCivilite">Civilite</label>
			<div class="col-sm-3">
				<form:input path="civilite" type="text" class="form-control"
					id="idCivilite" placeholder="Civilite" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idNom">Nom</label>
			<div class="col-sm-3">
				<form:input path="nom" type="text" class="form-control" id="idNom"
					placeholder="Nom" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idPrenom">Prenom</label>
			<div class="col-sm-3">
				<form:input path="prenom" type="text" class="form-control"
					id="idPrenom" placeholder="Prenom" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idDn">Date de
				naissance</label>
			<div class="col-sm-3">
				<form:input path="dn" type="date" class="form-control" id="idDn" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idAdresse">Adresse</label>
			<div class="col-sm-3">
				<form:input path="adresse" type="text" class="form-control"
					id="idAdresse" placeholder="Adresse" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idTel">Telephone</label>
			<div class="col-sm-3">
				<form:input path="telephone" type="text" class="form-control"
					id="idTel" placeholder="Telephone" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idNationalite">Nationalite</label>
			<div class="col-sm-3">
				<form:input path="nationalite" type="text" class="form-control"
					id="idNationalite" placeholder="Nationalite" />
			</div>
		</div>
		<br/>
		<div class="col-sm-3">
			<input class="btn btn-primary" type="submit" value="Continuer" />
		</div>
		
		
	</form:form>
	
	</div>
	
<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>
</body>
</html>