<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Ajouter la lib fmt de jstl qui sert a l'internationalisation de mon app -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Liste des voyageurs</title>

<!--  lier le fichier css à ma page car boostrap ne se trouve pas dans le même fichier que ma page -->
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>" />


</head>


<body>

<h1 style="color: red; text-align: center;">Liste des voyageurs</h1>
	<table class="table table-bordered">
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Numéro de siège</th>
			<th>Numéro de dossier</th>
			<th>Date de naissance</th>
			<th>Adresse</th>
			<th>Téléphone</th>
			<th>Nationalité</th>
			<th>Opérations</th>
		</tr>

		<c:forEach var="v" items="${voyageurs}">
			<tr>
				<td>${v.nom}</td>
				<td>${v.prenom}</td>
				<td>${v.numSiege}</td>
				<td>${v.dossier}</td>
				<td><fmt:formatDate value="${v.dn}" pattern="dd/MM/yyyy"/></td>
				<td>${v.adresse}</td>
				<td>${v.telephone}</td>
				<td>${v.nationalite}</td>
				<!-- pour accèder directement au dossier voyageur-->
				<td><a href="<c:url value='  '/>"><b>Accès dossier</b></a> |
				<a href="<c:url value='/admin/updateVoyageur?pId=${v.id}'/>"><b>Modifier</b></a> |
				<a href="<c:url value='/admin/submitVoyageur?pId=${v.id}'/>"><b>Supprimer</b></a>
			</tr>
		</c:forEach>
	</table>



</body>
</html>