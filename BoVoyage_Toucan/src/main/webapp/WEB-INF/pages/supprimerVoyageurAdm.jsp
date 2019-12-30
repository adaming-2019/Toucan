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
<title>Suppression Voyageur</title>

<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre" style="color: red; text-align: center;">Formulaire
		de suppression</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>


	<form:form method="get" action="deleteVoyageur">
		Id : <input type="number" name="pId" />
		<br />
		<br />
		<input class="btn btn-danger" type="submit"
			value="supprimer le voyageur">
	</form:form>

	<h1 style="color: red; text-align: center;">${msg}</h1>

	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>
</body>
</html>