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
<title>Choix du nombre de places</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h2 style="color: slateBlue; text-align: center">Combien de places
		souhaitez-vous réserver ?</h2>
		
	<div class="formulaire">

	<form:form class="form-horizontal" method="POST"
		action="saisieVoyageur" modelAttribute="dossier">
		<div class="form-group">
			<label class="control-label col-sm-4" for="idChx">Choix du
				nombre de places</label>
			<div class="col-sm-2">
				<form:input path="nbPlaces" type="text" class="form-control"
					id="idChx" />
			</div>
		</div>
		<input type="hidden" value="${pId}" />

		<%-- Choix du nombre de places : 
		<form:input path="nbPlaces" />
		<form:input type="hidden" path="etat" value="${dossier.etat}" />
		<br /> --%>
		<input class="btn btn-primary" type="submit" value="Continuer" />
	</form:form>
	
	</div>
	
	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>

</body>
</html>