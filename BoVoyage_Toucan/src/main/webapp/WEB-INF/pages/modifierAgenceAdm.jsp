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
<title>modifer agence adm</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="../templates/header.html"%>
	<h1 style="color: red; text-align: center">Formulaire de
		modification</h1>

	<form:form class="form-horizontal" method="POST"
		action="submitUpdateAgence" modelAttribute="agUpdate">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idNom">Nom</label>
			<div class="col-sm-2">
				<form:input path="nom" type="text" class="form-control" id="idNom"
					placeholder="Nom" />
			</div>
		</div>
		<div class="control-label col-sm-1">
			<input class="btn btn-primary" type="submit" value="Modifier" />
		</div>
	</form:form>
</body>
</html>