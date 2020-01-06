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
<title>Dossiers clients</title>

<!--  lier le fichier css à ma page car boostrap ne se trouve pas dans le même fichier que ma page -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/assets/css/BoVoyageStyle.css' />" />
</head>


<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Liste dossier clients</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	
	<div style="text-align: center" class="control-label col-sm-9">
	
	
	<table class="table table-bordered">
	<tr>
		<th  style="text-align: center" >Id</th>
		<th  style="text-align: center" >Etat</th>
		<th  style="text-align: center" >Nombre de places</th>
		<th  style="text-align: center" >Nom Client</th>
		<th  style="text-align: center" >Prénom Client</th>
		<th  style="text-align: center" >Opérations</th>
	</tr>
<c:forEach var="d" items="${dossiers}">
			<tr>
				<td>${d.id}</td>
				<td>${d.etat}</td>
				<td>${d.nbPlaces}</td>
				<td>${d.client.nom}</td>
				<td>${d.client.prenom}</td>
				
				<td><a href="<c:url value='/admin/updateDossier=${d.id}'/>"><b>Modifier</b></a> |
				<!-- supprimer directement le dossier via la page de la liste -->
				<a href="<c:url value='/admin/deleteDossier?pId=${d.id}'/>"><b>Supprimer</b></a></td>
			</tr>
			</c:forEach>
	</table>
</div>
	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>

</body>
</html>