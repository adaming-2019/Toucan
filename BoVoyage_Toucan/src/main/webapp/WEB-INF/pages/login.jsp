<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/headerPublic.html"%>
	<h1 id="titre">Connexion à votre compte</h1>
	<br />
	
	<div class="formulaire">
	<form action="public/connexion" method="post">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idUsername">Login : </label>
			<div class="col-sm-2">
				<input name="j_username" type="text" class="form-control"
					id="idUsername" placeholder="Login" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPassword">Mot de passe : </label>
			<div class="col-sm-2">
				<input name="j_password" type="password" class="form-control"
					id="idPassword" placeholder="Mot de passe" />
			</div>
		</div>
		<input class="btn btn-info" type="submit" value="Se connecter" />
	</form>
	<br />
	<h1 style="color: red; text-align: center">${msg}</h1>
	</div>
	
</body>
</html>