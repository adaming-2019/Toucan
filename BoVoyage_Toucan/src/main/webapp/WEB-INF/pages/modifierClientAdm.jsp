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
<title>modifer client adm</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Formulaire de modification</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>

	<form:form method="POST" action="submitUpdateClient" modelAttribute="cUpdate">
		Id : <form:input path="id" />
		<br/>

		Adresse : <form:input path="adresse" />
		<br/>
		Civilite : <form:input path="civilite" />
		<br/>
		Date naissance : <form:input type="date" path="dn" />
		<br/>
		Nationalite : <form:input path="nationalite" />
		<br/>	
		Nom : <form:input path="nom" />
		<br/>
		Prenom : <form:input path="prenom" />
		<br/>
		Telephone : <form:input path="telephone" />
		<br/>


		CB : <form:input path="cb" />
		<br/>
		Login : <form:input path="login" />
		<br/>
		Mdp : <form:input path="mdp" />
		<br/>
		Statut : <form:input path="active" />
		<br/>				
		
		
		<input type="submit" value="Modifier" />
	</form:form>


</body>
</html>