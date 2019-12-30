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
<title>ajouter client adm</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>

	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	
		<br />
	<%@include file="/templates/menuAdm.html"%>
	
	<form:form class="form-horizontal" method="POST"
		action="addDestination" modelAttribute="destiAdd"
		enctype="multipart/form-data">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPays">Pays</label>
			<div class="col-sm-2">
				<form:input path="pays" type="text" class="form-control" id="idPays"
					placeholder="Pays" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1">Photo</label>
			<div class="col-sm-2">
				<input type="file" name="files" multiple="multiple"/>
			</div>
			<div class="col-sm-3">
				<input class="btn btn-success" type="submit" value="Ajouter" />
			</div>
		</div>
	</form:form>
</body>
</html>