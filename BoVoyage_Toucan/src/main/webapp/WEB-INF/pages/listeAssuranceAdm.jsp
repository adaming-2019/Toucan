<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Assurance</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="../templates/header.html"%>
	<h1 style="color: red; text-align: center">Listes des assurances
		disponibles</h1>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Montant</th>
			<th>Type</th>
			<th>Fonctionnalités</th>
		</tr>

		<c:forEach var="as" items="${assurances}">
			<tr>
				<th>${as.id}</th>
				<th>${as.montant}</th>
				<th>${as.type}</th>
				<td><a href="<c:url value='/admin/afficherAddAssurance'/>">Ajouter</a><a
					href="<c:url value='/admin/afficherUpdateAssurance?pId=${as.id}'/>">Modifier</a>
					<a
					href="<c:url value='/admin/submitDeleteAssurance?pId=${as.id}'/>">Supprimer</a>
				</td>
			</tr>


		</c:forEach>
	</table>

</body>
</html>