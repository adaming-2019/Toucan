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
<title>Liste des voyageurs</title>
<!-- Lier lb bootstrap � ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Liste des voyageurs</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<div style="text-align: center" class="control-label col-sm-9">
		<table class="table table-bordered">
			<tr>
				<th>Nom</th>
				<th>Pr�nom</th>
				<th>Num�ro de si�ge</th>
				<th>Num�ro de dossier</th>
				<th>Date de naissance</th>
				<th>Adresse</th>
				<th>T�l�phone</th>
				<th>Nationalit�</th>
				<th>Op�rations</th>
			</tr>

			<c:forEach var="v" items="${voyageurs}">
				<tr>
					<td>${v.nom}</td>
					<td>${v.prenom}</td>
					<td>${v.numSiege}</td>
					<td>${v.dossier}</td>
					<td><fmt:formatDate value="${v.dn}" pattern="dd/MM/yyyy" /></td>
					<td>${v.adresse}</td>
					<td>${v.telephone}</td>
					<td>${v.nationalite}</td>
					<!-- pour acc�der directement au dossier voyageur-->
					<td><a href="<c:url value='  '/>"><b>Acc�s dossier</b></a> | <a
						href="<c:url value='/admin/updateVoyageur?pId=${v.id}'/>"><b>Modifier</b></a>
						| <a href="<c:url value='/admin/submitVoyageur?pId=${v.id}'/>"><b>Supprimer</b></a>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>