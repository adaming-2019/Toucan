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
<title>Modification voyageur</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />


</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Formulaire de modification</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<form:form method="get" action="modifVoyageur">
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
				<form:input path="prenom" type="date" class="form-control"
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
			<label class="control-label col-sm-1" for="idSiege">Numero du
				siège</label>
			<div class="col-sm-2">
				<form:input path="numSiege" type="text" class="form-control"
					id="idSiege" placeholder="Numero de siege" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idDossier">Dossier</label>
			<div class="col-sm-2">
				<form:input path="dossier" type="text" class="form-control"
					id="idDossier" placeholder="Dossier" />
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
				<input class="btn btn-warning" type="submit" value="Modifier" />
			</div>
		</div>

		<%-- 		Id : <input type="number" name="pId" /> 
		<br /> 
		Nom :<form:input type="text" path="nom" />
		<br /> 
		Prénom:<form:input type="text" path="prenom" />
		<br /> 
		Date: <form:input type="date" path="dn" />
		<br /> 
		Numéro de siège:
		<form:input type="number" path="numSiege" />
		<br /> Numéro de dossier :
		<form:input type="number" path="dossier" />
		<br /> Adresse :
		<form:input type="number" path="adresse" />
		<br /> Téléphone :
		<form:input type="number" path="telephone" />
		<br /> Nationalité:
		<form:input type="number" path="nationalite" />

		<br /> <br /> <input class="btn btn-warning" type="submit"
			value="modifier"> --%>
	</form:form>

	<h1 style="color: red; text-align: center;">${msg}</h1>
<body>

</body>
</html>