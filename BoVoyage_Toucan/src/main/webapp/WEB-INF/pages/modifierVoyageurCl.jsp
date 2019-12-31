<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un voyageur</title>

<!-- Lier la librairie bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>

	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	
	
	<h2 id="titre">Modifier les informations du voyageur</h2>
	
	<div class="formulaire">
	
	<form:form action="submitModifVoyageur" method="post" modelAttribute="voyageur">
	
		<form:input path="id" type="hidden"/>
		
		<form:input path="dossier" type="hidden"/>
		
		<form:input path="numSiege" type="hidden"/>
	
		<div class="form-group">
			<label class="control-label col-sm-3" for="idCivilite">Civilité</label>
			<div class="col-sm-3">
				<form:input path="civilite" type="text" class="form-control"
					id="idCivilite"/>
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idNom">Nom</label>
			<div class="col-sm-3">
				<form:input path="nom" type="text" class="form-control" id="idNom"/>
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idPrenom">Prénom</label>
			<div class="col-sm-3">
				<form:input path="prenom" type="text" class="form-control"
					id="idPrenom"/>
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
					id="idAdresse"/>
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idTel">Téléphone</label>
			<div class="col-sm-3">
				<form:input path="telephone" type="text" class="form-control"
					id="idTel"/>
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-3" for="idNationalite">Nationalité</label>
			<div class="col-sm-3">
				<form:input path="nationalite" type="text" class="form-control"
					id="idNationalite"/>
			</div>
			<div class="col-sm-3">
				<input class="btn btn-primary" type="submit" value="Enregistrer" />
			</div>
		</div>
	
	</form:form>
	
	</div>
	
	
	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>

</body>
</html>