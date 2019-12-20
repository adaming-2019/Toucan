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
</head>
<body>
	<h1 style="color: red; text-align: center">Listes des agences de
		voyages</h1>
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
				<td><a
					href="<c:url value='/admin/submitAddAgence?pId=${a.id}'/>">Ajouter</a><a
					href="<c:url value='/admin/submitUpdateAgence?pId=${a.id}'/>">Modifier</a>
					<a href="<c:url value='/admin/submitDeleteAgence?pId=${a.id}'/>">Supprimer</a>
				</td>
			</tr>


		</c:forEach>
	</table>
</body>
</html>