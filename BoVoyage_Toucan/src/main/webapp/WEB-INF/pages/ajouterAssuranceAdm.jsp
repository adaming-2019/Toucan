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
<!-- Lier lb bootstrap � ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
</head>
<body>
	<h1 style="color: red; text-align: center">Formulaire d'ajout</h1>

	<form:form class="form-horizontal" method="POST"
		action="submitAddAssurance" modelAttribute="asAdd">
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
		</div>
		<div class="control-label col-sm-1">
			<input class="btn btn-success" type="submit" value="Ajouter" />
		</div>
	</form:form>
</body>
</html>