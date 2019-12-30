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
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet" href="<c:url value='/assets/css/BoVoyageStyle.css' />" />


</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Formulaire de modification</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<form:form method="POST" action="updateVoyageur" modelAttribute="vgrModif">
	
		<div class="form-group">
			<label class="control-label col-sm-1" for="idSiege">Numero du siège</label>
			<div class="col-sm-2">
				<form:input path="numSiege"  type="text" class="form-control" id="idSiege" />
			</div>
		</div>
		<br />
		<br />
		<div class="form-group">
			<label class="control-label col-sm-1" for="idDossier">Dossier</label>
			<div class="col-sm-2">
				<form:input path="dossier" type="text" class="form-control" id="idDossier" placeholder="Dossier" />
			</div>
	
			<div class="col-sm-3">
				<input class="btn btn-warning" type="submit" value="Modifier" />
			</div>
		</div>

	</form:form>

	<h1 style="color: red; text-align: center;">${msg}</h1>
<body>

</body>
</html>