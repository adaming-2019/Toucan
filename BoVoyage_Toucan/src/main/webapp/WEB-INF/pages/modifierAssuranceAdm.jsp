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
<title>ajouter assurance adm</title>
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

	<form:form class="form-horizontal" method="POST"
		action="submitUpdateAssurance" modelAttribute="asUpdate">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idMontant">Montant</label>
			<div class="col-sm-2">
				<form:input path="montant" type="text" class="form-control"
					id="idMontant" placeholder="Montant" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1" for="idType">Type</label>
			<div class="col-sm-2">
				<form:input path="type" type="text" class="form-control" id="idType"
					placeholder="Type" />
			</div>
			<div class="col-sm-3">
				<input class="btn btn-primary" type="submit" value="Modifier" />
			</div>
		</div>
	</form:form>
</body>
</html>