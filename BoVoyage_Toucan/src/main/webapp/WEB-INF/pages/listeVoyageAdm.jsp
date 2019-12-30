<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Voyage</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Liste des voyages disponibles</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>

	<!-- Image de du dans la page jsp -->
	<!--
	<img src="${pageContext.request.contextPath}/assets/images/bird.png"/>
	-->
	<!--
	${v.photos}
	-->

	<div style="text-align: center" class="control-label col-sm-7">
		<table class="table table-bordered">
			<tr>
				<th>Date Aller</th>
				<th>Date Retour</th>
				<th>Nombre de places</th>
				<th>Photo</th>
				<th>Prix Agence</th>
				<th>Prix BoVoyage</th>
				<th>Agence</th>
				<th>CategorieVehicule</th>
				<th>Destination</th>
				<th>Formule</th>
				<th>LoueurVehicule</th>
				<th>Prestation</th>
				<th>Operations</th>
			</tr>

			<c:forEach var="v" items="${voyages}">
				<tr>
					<td><fmt:formatDate value="${v.dateDebut}"
							pattern="dd-MM-yyyy" /></td>
					<td><fmt:formatDate value="${v.dateRetour}"
							pattern="dd/MM/yyyy" /></td>
					<td>${v.nombrePlace}</td>
					<td><img src="${pageContext.request.contextPath}/assets/photos/${v.photos}"/></td>
					<td>${v.prixAgence}</td>
					<td>${v.prixBoVoyage}</td>
					<td>${v.agence.nom}</td>
					<td>${v.categorieVehicule.categorieVehicule}</td>
					<td>${v.destination.continent} ${v.destination.pays}</td>
					<td>${v.formule.formule}</td>
					<td>${v.loueurVehicule.loueurVehicule}</td>
					<td>${v.prestation.prestation}</td>
					<td><a href="<c:url value='/admin/afficherAddVoyage'/>">Ajouter</a> | <a
						href="<c:url value='/admin/linkUpdateVoyage?pId=${v.id}'/>">Modifier</a> | 
						<a
						href="<c:url value='/admin/submitDeleteVoyage?pId=${v.id}'/>">Supprimer</a>
					</td>
				</tr>


			</c:forEach>
		</table>
	</div>


</body>
</html>