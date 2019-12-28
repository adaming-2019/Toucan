<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--  ajouter la taglib form de srping -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dossiers clients</title>

<!--  lier le fichier css � ma page car boostrap ne se trouve pas dans le m�me fichier que ma page -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
</head>


<body>

	<h1>Liste des dossiers clients</h1>

	<table class="table table-bordered">
	<tr>
		<tr>Etat</tr>
		<tr>Nombre de places</tr>
		<tr>Nom Client</tr>
		<tr>Pr�nom Client</tr>
		<tr>Voyage</tr>
		<tr>Assurance</tr>
	</tr>
<c:forEach var="d" items="${dossiers}">
			<tr>
				<td>${d.etat}</td>
				<td>${d.nbPlaces}</td>
				<td>${d.nom}</td>
				<td>${d.prenom}</td>
				<td>${d.voyage}</td>
				<td>${v.assurances}</td>
				
				<td><a href="<c:url value='/admin   =${d.id}'/>"><b>Modifier</b></a>
				<!-- supprimer directement le dossier via la page de la liste -->
				<a href="<c:url value='/admin   =${d.id}'/>"><b>Supprimer</b></a></td>
			</tr>
			</c:forEach>
	</table>



</body>
</html>