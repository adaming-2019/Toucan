<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Agences</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Liste des agences de voyages</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<div style="text-align: center" class="control-label col-sm-7">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Fonctionnalités</th>
			</tr>

			<c:forEach var="a" items="${agences}">
				<tr>
					<th>${a.id}</th>
					<th>${a.nom}</th>
					<td><a href="<c:url value='/admin/afficherAddAgence'/>">Ajouter</a>
						| <a href="<c:url value='/admin/linkUpdateAgence?pId=${a.id}'/>">Modifier</a>
						| <a href="<c:url value='/admin/submitDeleteAgence?pId=${a.id}'/>">Supprimer</a>
					</td>
				</tr>


			</c:forEach>
		</table>
	</div>
</body>
</html>