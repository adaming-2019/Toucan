<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />
<meta charset="ISO-8859-1">
<title>Liste Continents</title>
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Listes des continents disponibles</h1>
	<br />

	<div style="text-align: center" class="control-label col-sm-4">


		<select name="pContinent" class="form-control">
			<c:forEach var="cont" items="${listeCont}">
				<option>${cont}</option>
			</c:forEach>

		</select> <br /> <br /> <br />

		<button type="submit" class="btn btn-default" value="Rechercher">Recherche</button>
		<br /> <br /> <br />

	</div>
</body>
</html>
