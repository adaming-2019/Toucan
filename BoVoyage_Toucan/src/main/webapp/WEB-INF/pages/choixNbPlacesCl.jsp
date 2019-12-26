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
<title>Choix du nombre de places</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h2 style="color: slateBlue; text-align: center">Combien de places
		souhaitez-vous réserver ?</h2>

	<form:form method="POST" action="saisieVoyageur"
		modelAttribute="dossier">
		Choix du nombre de places : <form:input path="nbPlaces" />
		<form:input type="hidden" path="etat" value="${dossier.etat}" />
		<br />
		<input type="submit" value="Continuer" />
	</form:form>

</body>
</html>