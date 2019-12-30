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
<title>Creer compte</title>
<!-- Lier lb bootstrap � ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Cr�er votre compte client BoVoyage</h1>
	<div>
		<form:form class="form-horizontal" id="login" method="POST"
			action="submitCreateAccount" modelAttribute="compteAdd">

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
				<label class="control-label col-sm-1" for="idCivilite">Civilite</label>
				<div class="col-sm-2">
					<form:input path="civilite" type="text" class="form-control"
						id="idCivilite" placeholder="Civilite" />
				</div>
			</div>
			<br />
			<br />
			<div class="form-group">
				<label class="control-label col-sm-1" for="idDn">Date de
					naissance</label>
				<div class="col-sm-2">
					<form:input path="dn" type="date" class="form-control" id="idDn"
						placeholder="Date de naissance" />
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
			<div class="form-group">
				<label class="control-label col-sm-1" for="idTelephone">Telephone</label>
				<div class="col-sm-2">
					<form:input path="telephone" type="text" class="form-control"
						id="idTelephone" placeholder="Telephone" />
				</div>
			</div>
			<br />
			<br />
			<div class="form-group">
				<label class="control-label col-sm-1" for="idCB">CB</label>
				<div class="col-sm-2">
					<form:input path="cb" type="text" class="form-control" id="idCB"
						placeholder="CB" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-1" for="idLogin">Login</label>
				<div class="col-sm-2">
					<form:input path="login" type="text" class="form-control"
						id="idLogin" placeholder="Login" />
				</div>
			</div>
			<br />
			<br />
			<div class="form-group">
				<label class="control-label col-sm-1" for="idMdp">Mot de
					passe</label>
				<div class="col-sm-2">
					<form:input path="mdp" type="text" class="form-control" id="idMdp"
						placeholder="Mot de passe" />
				</div>
			</div>
			<br />
			<br />
			<div class="form-group">
				<label class="control-label col-sm-1" for="idStatut">Statut</label>
				<div class="col-sm-2">
					<form:input path="active" type="text" class="form-control"
						id="idStatut" placeholder="Statut" />
				</div>
				<div class="col-sm-3">
					<input class="btn btn-success" type="submit"
						value="Cr�er son compte" />
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>