<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Client</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Liste des clients disponibles</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>

	<!-- Image de du dans la page jsp -->
	<!--
	<img src="${pageContext.request.contextPath}/assets/images/bird.png"/>
	-->
	<!--
	${v.photos}
	-->

	<div style="text-align: center" class="control-label col-sm-7">
		<table class="table table-bordered">
			<tr>
				<th>Adresse</th>
				<th>Civilite</th>
				<th>Date naissance</th>
				<th>Nationalite</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Telephone</th>
				
				<th>CB</th>
				<th>Login</th>
				<th>Mdp</th>
				<th>Statut</th>
				<th>Operations</th>
			</tr>

			<c:forEach var="c" items="${clients}">
				<tr>
					<td>${c.adresse}</td>
					<td>${c.civilite}</td>
					<td><fmt:formatDate value="${c.dn}" pattern="dd-MM-yyyy" /></td>
					<td>${c.nationalite}</td>
					<td>${c.nom}</td>
					<td>${c.prenom}</td>
					<td>${c.telephone}</td>
					
					<td>${c.cb}</td>
					<td>${c.login}</td>
					<td>${c.mdp}</td>
					<td>${c.active}</td>
					<td><a href="<c:url value='/admin/afficherAddClient'/>">Ajouter</a> | <a
						href="<c:url value='/admin/linkUpdateClient?pId=${c.id}'/>">Modifier</a> | 
						<a
						href="<c:url value='/admin/submitDeleteClient?pId=${c.id}'/>">Supprimer</a>
					</td>
				</tr>


			</c:forEach>
		</table>
	</div>
</body>
</html>