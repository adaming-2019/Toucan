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
<title>ajouter agence adm</title>
<!-- Lier lb bootstrap � ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Formulaire d'ajout</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<form:form class="form-horizontal" method="POST" action="submitAddAgence" modelAttribute="agAdd">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idNom">Nom</label>
			<div class="col-sm-2">
				<form:input path="nom" type="text" class="form-control" id="idNom"
					placeholder="Nom" />
			</div>
			<div class="col-sm-3">
				<input class="btn btn-success" type="submit" value="Ajouter" />
			</div>
		</div>

	</form:form>
	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>
</body>
</html>