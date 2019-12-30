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
<title>Destinations</title>

<!--  lier le fichier css à ma page car boostrap ne se trouve pas dans le même fichier que ma page -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/assets/css/BoVoyageStyle.css'/>"/>
</head>

<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Liste des destinations proposées</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>

	<div style="text-align: center" class="control-label col-sm-9">
		<table class="table table-bordered">
			<tr>
				<th>Contient</th>
				<th>Pays</th>
			</tr>
			<c:forEach var="d" items="${destinations}">
				<tr>
					<td>${d.continent}</td>
					<td>${d.pays}</td>
					<td><a href="<c:url value='/admin/addDestination=${d.id}'/>"><b>Ajouter</b></a>
						| <!-- supprimer directement la destination via la page de la liste -->
						<a href="<c:url value='/admin/suppDestination=${d.id}'/>"><b>Supprimer</b></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>