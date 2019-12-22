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

	<form:form method="POST" action="#" modelAttribute="dossier">
		Choix du nombre de places : <form:input path="nbPlaces"/>
		<input type="submit" value="Valider"/>
	</form:form>

</body>
</html>