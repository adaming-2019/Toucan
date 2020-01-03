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
	<%@include file="/templates/headerPublic.html"%>
	<h1 id="titre">Listes des voyages disponibles</h1>
	<br />
	<c:forEach var="v" items="${voyages}">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">${v.destination.pays}</div>
				<div class="panel-body">
					<table>
						<tr>
							<!-- 	<th>Destination</th> -->
							<th>Depart</th>
							<th>Retour</th>
							<th>Places disponibles</th>
							<th>Prix agence</th>
							<th>Prix réduit BoVoyage</th>
							<th>Opération</th>
						</tr>
						<tr>
							<%-- 	<td><c:forEach var="ph" items="${v.destination.images}">
									<img src="${ph.photoString}" style="width: 90px; height: 90px" />
								</c:forEach></td> --%>
							<%-- <td>${v.destination.pays}</td> --%>
							<td><fmt:formatDate value="${v.dateDebut}"
									pattern="dd/MM/yyyy" /></td>
							<td><fmt:formatDate value="${v.dateRetour}"
									pattern="dd/MM/yyyy" /></td>
							<td>${v.nombrePlace}</td>
							<td>${v.prixAgence}</td>
							<td>${v.prixBoVoyage}</td>
							<td><a
								href="<c:url value='/client/choixNbPlaces?pId=${v.id}' />">Réserver</a>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>
