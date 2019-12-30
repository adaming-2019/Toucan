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

<!--  lier le fichier css à ma page car boostrap ne se trouve pas dans le même fichier que ma page -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
</head>


<body>

	<h1 style="color: red; text-align: center;">Liste des dossiers clients</h1>
	<table class="table table-bordered">
	<tr>
		<th>Id</th>
		<th>Voyage</th>
		<th>Etat</th>
		<th>Nombre de places</th>
		<th>Nom Client</th>
		<th>Prénom Client</th>
		<th>Voyageurs accompagnants</th>
		<th>Assurance</th>
		<th>Opérations</th>
	</tr>
<c:forEach var="d" items="${dossiers}">
			<tr>
				<td>${d.id}</td>
				<td>${d.voyage}</td>
				<td>${d.etat}</td>
				<td>${d.nbPlaces}</td>
				<td>${d.client.nom}</td>
				<td>${d.client.prenom}</td>
				<td>${d. }</td>
				<td>${d.assurances}</td>
				
				<td><a href="<c:url value='/admin/updateDossier=${d.id}'/>"><b>Modifier</b></a> |
				<!-- supprimer directement le dossier via la page de la liste -->
				<a href="<c:url value='/admin/deleteDossier =${d.id}'/>"><b>Supprimer</b></a></td>
			</tr>
			</c:forEach>
	</table>

	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>

</body>
</html>