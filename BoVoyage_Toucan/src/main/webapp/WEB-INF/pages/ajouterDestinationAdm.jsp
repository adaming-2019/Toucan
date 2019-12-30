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
<title>Ajouter Destination</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet" href="<c:url value='/assets/css/BoVoyageStyle.css' />" />
</head>

<body>

<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Ajouter une nouvelle destination</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>

<form:form cssClass="form-horizontal" method="post" action="addDestination" modelAttribute="destiAdd">
<div class="form-group">

<label class="control-label col-sm-1" for="idContinent">Continent</label>
			<div class="col-sm-2">
				<form:input path="continent" type="text" class="form-control" id="idContinent" placeholder="Continent" />
			</div>
			
			<label class="control-label col-sm-1" for="idPays">Pays</label>
			<div class="col-sm-2">
				<form:input path="pays" type="text" class="form-control" id="idPays" placeholder="Pays" />
			</div>	
			<div class="col-sm-3">
				<input class="btn btn-success" type="submit" value="Ajouter cette destination" />
			</div>
				
		</div>

			
	
</form:form>
</body>
</html>