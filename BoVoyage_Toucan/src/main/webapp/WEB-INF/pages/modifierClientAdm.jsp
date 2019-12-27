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
<title>modifer client adm</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Formulaire de modification</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>

	<form:form method="POST" action="submitUpdateClient"
		modelAttribute="cUpdate">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idID">ID</label>
			<div class="col-sm-2">
				<form:input path="id" type="text" class="form-control" id="idID"
					placeholder="Adresse" />
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
			<label class="control-label col-sm-1" for="idCivilite">Civilite</label>
			<div class="col-sm-2">
				<form:input path="civilite" type="text" class="form-control"
					id="idCivilite" placeholder="Civilite" />
			</div>
		</div>
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
				<input class="btn btn-primary" type="submit" value="Modifier" />
			</div>
		</div>
		<%-- 		Id : <form:input path="id" /> --%>
		<!-- 		<br /> -->

		<%-- 		Adresse : <form:input path="adresse" /> --%>
		<!-- 		<br /> -->
		<%-- 		Civilite : <form:input path="civilite" /> --%>
		<!-- 		<br /> -->
		<%-- 		Date naissance : <form:input type="date" path="dn" /> --%>
		<!-- 		<br /> -->
		<%-- 		Nationalite : <form:input path="nationalite" /> --%>
		<!-- 		<br />	 -->
		<%-- 		Nom : <form:input path="nom" /> --%>
		<!-- 		<br /> -->
		<%-- 		Prenom : <form:input path="prenom" /> --%>
		<!-- 		<br /> -->
		<%-- 		Telephone : <form:input path="telephone" /> --%>
		<!-- 		<br /> -->


		<%-- 		CB : <form:input path="cb" /> --%>
		<!-- 		<br /> -->
		<%-- 		Login : <form:input path="login" /> --%>
		<!-- 		<br /> -->
		<%-- 		Mdp : <form:input path="mdp" /> --%>
		<!-- 		<br /> -->
		<%-- 		Statut : <form:input path="active" /> --%>
		<!-- 		<br /> -->

	</form:form>


</body>
</html>