<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sélection des assurances</title>
</head>
<body>

	<h2 style="color: slateBlue; text-align: center">Souhaitez-vous sélectionner des assurances pour votre voyage ?</h2>
	
	<form:form method="POST" action="submitChoixAssurance" modelAttribute="selection">
		<form:checkboxes items="${types}" path="choix"/>
		<input type="submit" value="Continuer"/>
	</form:form>

</body>
</html>