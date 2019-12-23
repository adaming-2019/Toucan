<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informations voyageurs</title>
</head>
<body>

	<h2 style="color: slateBlue; text-align: center">Veuillez saisir les informations du voyegeur numéro ${noVoyageur}</h2>
	
	<form:form action="submitSaisieVoyageur" method="POST" modelAttribute="voyageur">
	<input type="hidden" name="noVoyageur" value="${noVoyageur}"/>
		Civilité : <form:input path="civilite"/>
		<br/>
		Nom : <form:input path="nom"/>
		<br/>
		Prénom : <form:input path="prenom"/>
		<br/>
		Date de naissance : <form:input type="date" path="dn"/>
		<br/>
		Adresse : <form:input path="adresse"/>
		<br/>
		Téléphone : <form:input path="telephone"/>
		<br/>
		Nationalité : <form:input path="nationalite"/>
		<br/>
		<input type="submit" value="Continuer"/>
	</form:form>

</body>
</html>