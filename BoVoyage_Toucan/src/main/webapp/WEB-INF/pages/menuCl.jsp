<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon espace client</title>

<!-- Lier la librairie bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>

	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>

	<form class="form-inline" action="detailsDossier" method="get">
		<div class="form-group">
			<label for="idDossier">Consulter un dossier : </label> <input
				type="number" class="form-control" id="idDossier"
				placeholder="N° de dossier" name="pIdDossier">
		</div>
		<button class="btn btn-info">Rechercher</button>
	</form>

	<br />
	<h2 id="titre">Liste de vos dossiers</h2>

	<table class="table table-bordered">
		<tr>
			<th>N° de dossier</th>
			<th>Etat</th>
			<th>Opérations</th>
		</tr>
		<c:if test="${not empty dossiers}">
			<tr>Vous n'avez aucune réservation en cours.</tr>
		</c:if>
		<c:forEach var="d" items="${dossiers}">
		<c:if test="${d.etat!=annule}">
			<tr>
				<td>${d.id}</td>
				<td>${d.etat}</td>
				<td><a
					href="<c:url value='/client/detailsDossier?pIdDossier=${d.id}'/>">Consulter</a></td>
			</tr>
		</c:if>
		</c:forEach>
		

	</table>
<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>
</body>
</html>