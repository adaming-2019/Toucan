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
<title>modifer voyage adm</title>
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

	<form:form method="POST" action="submitUpdateVoyage"
		modelAttribute="vUpdate">
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
			<label class="control-label col-sm-1" for="idDdebut">Date de
				debut</label>
			<div class="col-sm-2">
				<form:input path="dateDebut" type="date" class="form-control"
					id="idDdebut" placeholder="Date de debut" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idDretour">Date de
				retour</label>
			<div class="col-sm-2">
				<form:input path="dateRetour" type="date" class="form-control"
					id="idDretour" placeholder="Date de retour" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idNbr">Nombre de
				Place</label>
			<div class="col-sm-2">
				<form:input path="nombrePlace" type="text" class="form-control"
					id="idNbr" placeholder="Nombre de place" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPrixA">Prix
				Agence</label>
			<div class="col-sm-2">
				<form:input path="prixAgence" type="text" class="form-control"
					id="idPrixA" placeholder="Prix agence" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPrixBV">Prix
				BoVoyage</label>
			<div class="col-sm-2">
				<form:input path="prixBoVoyage" type="text" class="form-control"
					id="idPrixBV" placeholder="Prix BoVoyage" />
			</div>
		</div>
		
		
				
		<div class="form-group">
			<label class="control-label col-sm-1" for="idAgence">Agence</label>
			<div class="col-sm-2">
				  <form:select path="agence.id" id="idAgence" >
					<c:forEach var="agences" items="${listeAgences}" varStatus="loop">
							<!--
							<option value="${agences.id}" >${agences}</option>
							-->
							<option value="${loop.index+1}" >${agences.nom}</option>
					</c:forEach>	
				  </form:select>
			</div>
		</div>	
		

		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idCategorieVehicule">CategorieVehicule</label>
			<div class="col-sm-2">
				  <form:select path="categorieVehicule.id" >
					<c:forEach var="cv" items="${listeCategorieVehicules}" varStatus="loop">
						<c:if test="${not loop.first}">
							<option value="${loop.index}" >${cv}</option>
						</c:if>
					</c:forEach>	
				  </form:select>
			</div>
		</div>
		
		
		<br />
		<br />
		
			<div class="form-group">
			<label class="control-label col-sm-1" for="idDestination">Destination</label>
			<div class="col-sm-2">
				  <form:select path="destination.id" >
					<c:forEach var="dest" items="${listeDestinations}" varStatus="loop">
							<!--
							<option value="${agences.id}" >${agences}</option>
							-->
							<option value="${loop.index+1}" >${dest}</option>
					</c:forEach>	
				  </form:select>
			</div>
		</div>	
		
		
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idFormule">Formule</label>
			<div class="col-sm-2">
				  <form:select path="formule.id" >
					<c:forEach var="form" items="${listeFormules}" varStatus="loop">
						<c:if test="${not loop.first}">
							<option value="${loop.index}" >${form}</option>
						</c:if>
					</c:forEach>	
				  </form:select>
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idLoueurVehicule">LoueurVehicule</label>
			<div class="col-sm-2">
				  <form:select path="loueurVehicule.id" >
					<c:forEach var="lv" items="${listeLoueurVehicules}" varStatus="loop">
						<c:if test="${not loop.first}">
							<option value="${loop.index}" >${lv}</option>
						</c:if>
					</c:forEach>	
				  </form:select>
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPrestation">Prestation</label>
			<div class="col-sm-2">
				  <form:select path="prestation.id" >
					<c:forEach var="prest" items="${listePrestations}" varStatus="loop">
						<c:if test="${not loop.first}">
							<option value="${loop.index}" >${prest}</option>
						</c:if>
					</c:forEach>	
				  </form:select>
			</div>
		</div>	
		
		
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idStatut">Statut</label>
			<div class="col-sm-2">
				<form:input path="statut" type="text" class="form-control"
					id="idStatut" placeholder="Statut" />
			</div>
			<div class="col-sm-3">
				<input class="btn btn-warning" type="submit" value="Modifier" />
			</div>
		</div>

		<%-- Id : <form:input path="id" />
		<br/>
		Date Debut : <form:input type="date" path="dateDebut" />
		<br/>
		Date Retour : <form:input type="date" path="dateRetour" />
		<br/>
		NombrePlace : <form:input path="nombrePlace" />
		<br/>
		PrixAgence : <form:input path="prixAgence" />
		<br/>
		PrixBoVoyage : <form:input path="prixBoVoyage" />
		<br/>
		Statut : <form:input path="statut" />
		<br/>				
		 --%>

	</form:form>


</body>
</html>