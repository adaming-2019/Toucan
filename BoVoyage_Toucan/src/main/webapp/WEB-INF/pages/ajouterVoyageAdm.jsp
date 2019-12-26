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
<title>ajouter voyage adm</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Formulaire d'ajout</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<form:form class="form-horizontal" method="POST"
		action="submitAddVoyage" modelAttribute="voyageAdd">

		Date Debut : <form:input type="date" path="dateDebut" />
		<br/>
		Date Retour : <form:input type="date" path="dateRetour" />
		<br/>
		NombrePlace : <form:input path="nombrePlace" />
		<br/>
		PrixAgence : <form:input path="prixAgence" />
		<br/>
		PrixBoVoyage : <form:input path="prixBoVoyage" />
		<br/>
		Statut : <form:input path="statut" />
		<br/>	
		<input type="submit" value="Ajouter" />
	</form:form>
</body>
</html>