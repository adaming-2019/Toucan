<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />
<meta charset="ISO-8859-1">
<title>Liste Voyages</title>
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Listes des voyages disponibles</h1>
	<br />

	<div style="text-align: center" class="control-label col-sm-4">

		<table class="table table-bordered">
			<tr>
				<th>Depart</th>
				<th>Return</th>
				<th>Nombre de place</th>
				<th>Prix Agence</th>
				<th>Prix BoVoyage</th>
			</tr>

			<c:forEach var="v" items="${voyages}">
				<tr>
					<td><fmt:formatDate value="${v.dateDebut}"
							pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${v.dateRetour}"
							pattern="dd/MM/yyyy" /></td>
					<td>${v.nombrePlace}</td>
					<td>${v.prixAgence}</td>
					<td>${v.prixBoVoyage}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
