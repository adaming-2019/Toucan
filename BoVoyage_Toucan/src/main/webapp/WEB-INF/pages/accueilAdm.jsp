<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil Administrateur</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Bienvenue dans votre espace administrateur</h1>
	<br />
	<%@include file="/templates/menuAdm.html"%>
	<div style="text-align: center" class="control-label col-sm-9">
		<h3 style="color: darkblue">Vous pouvez gérez les voyages, les
			clients et leurs dossiers à tout moment via le menu</h3>
		<img src="<c:url value='../asset/images/gestion.jpg'/>" class="image">
	</div>
</body>
</html>