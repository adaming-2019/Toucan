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
<title>Informations voyageurs</title>
<!-- Lier lb bootstrap � ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>

	<h2 style="color: slateBlue; text-align: center">Veuillez saisir
		les informations du voyageur num�ro ${noVoyageur}</h2>

	<form:form action="submitSaisieVoyageur" method="POST"
		modelAttribute="voyageur">
		Civilit� : <form:input path="civilite" />
		<br />
		Nom : <form:input path="nom" />
		<br />
		Pr�nom : <form:input path="prenom" />
		<br />
		Date de naissance : <form:input type="date" path="dn" />
		<br />
		Adresse : <form:input path="adresse" />
		<br />
		T�l�phone : <form:input path="telephone" />
		<br />
		Nationalit� : <form:input path="nationalite" />
		<br />
		<input type="submit" value="Continuer" />
	</form:form>

</body>
</html>