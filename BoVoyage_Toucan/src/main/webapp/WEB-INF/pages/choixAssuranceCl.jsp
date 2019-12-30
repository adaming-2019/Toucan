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
<title>Sélection des assurances</title>

<!-- Lier la librairie bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h2 style="color: slateBlue; text-align: center">Souhaitez-vous
		sélectionner des assurances pour votre voyage ?</h2>

	<h3>Liste des assurances disponibles</h3>
	<table class="table table-bordered">
		<tr>
			<th>Libellé</th>
			<th>Montant (EUR)</th>
		</tr>

		<c:forEach var="assurance" items="${assurances}">
			<tr>
				<td>${assurance.type}</td>
				<td>${assurance.montant}</td>
			</tr>
		</c:forEach>

	</table>

	<br />
	<br />

	<p>Je souhaite souscrire les assurances suivantes pour ma
		réservation :</p>
	<br />
	<form:form class="form-horizontal" method="POST"
		action="submitChoixAssurance" modelAttribute="selection">
		<div class="form-group">
			<form:checkboxes items="${types}" path="choix" />
		</div>
		<input class="btn btn-primary" type="submit" value="Continuer" />
	</form:form>
<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>
</body>
</html>