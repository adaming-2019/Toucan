<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Continents</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet" href="<c:url value='/assets/css/BoVoyageStyle.css' />" />


</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Listes des continents disponibles</h1>
	<br />
	<div id="login">
		<form:form class="form-horizontal" method="get"
			action="submitChoixContinent">
			<div class="col-sm-2">
				<select name="pContinent" class="form-control">
					<c:forEach var="cont" items="${listeCont}">
						<option>${cont}</option>
					</c:forEach>

				</select>
			</div>
			<br />
			<br />
			<br />

			<button type="submit" class="btn btn-info" value="Rechercher">Recherche</button>
			<br />
			<br />
			<br />
		</form:form>
	</div>
</body>
</html>
