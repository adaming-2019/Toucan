<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sélection des assurances</title>
</head>
<body>

	<h2 style="color: slateBlue; text-align: center">Souhaitez-vous sélectionner des assurances pour votre voyage ?</h2>
	
	<form method="GET" action="#">
		<c:forEach var="a" items="assurances">
			<input type="checkbox" name="${a.type}" value="yes"/>${a.type} (montant=${a.montant}) EUR
			<br/>
		</c:forEach>
		<input type="button" value="Continuer"/>
	</form>

</body>
</html>