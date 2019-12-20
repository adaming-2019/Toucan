<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ajouter taglib form de spring -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continent</title>

<!-- lier le fichier css de bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
	
</head>
<body>


	<h1 style="color: red; text-align: center;">Continents</h1>

<form action="">
<select>
	<c:forEach var="cont" items="${listeCont}">
		<option>${cont}</option>
	
	
	</c:forEach>


	</select>
</form>







</body>
</html>