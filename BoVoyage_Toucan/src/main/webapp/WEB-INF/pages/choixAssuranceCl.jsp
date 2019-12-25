<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sélection des assurances</title>

<!-- Lier le fichier css de bootstrap à ma page -->
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>"/>

</head>
<body>

	<h2 style="color: slateBlue; text-align: center">Souhaitez-vous sélectionner des assurances pour votre voyage ?</h2>
	
	<h3>Liste des assurances disponibles</h3>
	<table class="table">
		<tr>
			<th>Libellé</th>
			<th>Montant (EUR)</th>
		</tr>
		
		<c:forEach var="assurance" items="${assurances}">
			<tr>
				<td>${assurance.type}</td>
				<td>${assurance.montant}</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<br/>
	<br/>
	
	<p>Je souhaite souscrire les assurances suivantes pour ma réservation :</p>
	<br/>
	<form:form method="POST" action="submitChoixAssurance" modelAttribute="selection">
		<form:checkboxes items="${types}" path="choix"/>
		<input type="submit" value="Continuer"/>
	</form:form>

</body>
</html>