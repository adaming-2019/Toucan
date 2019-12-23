<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choix du nombre de places</title>
</head>
<body>

	<h2 style="color: slateBlue; text-align: center">Combien de places souhaitez-vous réserver ?</h2>

	<form:form method="POST" action="saisieVoyageur" modelAttribute="dossier">
		Choix du nombre de places : <form:input path="nbPlaces"/>
		<form:input type="hidden"  path="etat" value="${dossier.etat}"/>
		<br/>
		<input type="submit" value="Continuer"/>
	</form:form>

</body>
</html>