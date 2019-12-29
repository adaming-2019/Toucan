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
<title>Modification voyageur</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
 

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Formulaire de modification</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<form method="get" action="modifVoyageur">

		Id : <input type="number" name="pId" /> 
		<br /> 
		Nom :<form:input type="text" path="nom" />
		<br /> 
		Prénom:<form:input type="text" path="prenom" />
		<br /> 
		Date: <form:input type="date" path="dn" />
		<br /> 
		Numéro de siège:
		<form:input type="number" path="numSiege" />
		<br /> Numéro de dossier :
		<form:input type="number" path="dossier" />
		<br /> Adresse :
		<form:input type="number" path="adresse" />
		<br /> Téléphone :
		<form:input type="number" path="telephone" />
		<br /> Nationalité:
		<form:input type="number" path="nationalite" />

		<br /> <br /> <input class="btn btn-warning" type="submit"
			value="modifier">
	</form>

	<h1 style="color: red; text-align: center;">${msg}</h1>
<body>

</body>
</html>