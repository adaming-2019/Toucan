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
</head>
<body>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Nom</th>
		</tr>

		<c:forEach var="a" items="${assurances}">
			<tr>
				<th>${a.id}</th>
				<th>${a.montant}</th>
				<th>${a.type}</th>
				<td><a
					href="<c:url value='/admin/submitAddAssurance?pId=${a.id}'/>">Ajouter</a></td>
				<td><a
					href="<c:url value='/admin/submitUpdateAssurance?pId=${a.id}'/>">Modifier</a>
				</td>
				<td><a
					href="<c:url value='/admin/submitDeleteAssurance?pId=${a.id}'/>">Supprimer</a>
				</td>
			</tr>


		</c:forEach>
	</table>

</body>
</html>