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
	<%@include file="/templates/header.html"%>
	<h1 id="titre">Entrez vos identifiants pour connecter</h1>
	<br />
	<form action="admin/connexionAdm" method="post">
		<div class="form-group">
			<label class="control-label col-sm-1" for="idUsername">Username</label>
			<div class="col-sm-2">
				<input name="j_username" type="text" class="form-control"
					id="idUsername" placeholder="Username" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-1" for="idPassword">Password</label>
			<div class="col-sm-2">
				<input name="j_password" type="password" class="form-control"
					id="idPassword" placeholder="Password" />
			</div>
		</div>
		<input class="btn btn-info" type="submit" value="Se connecter" />
	</form>
	<br />
	<h1 style="color: red; text-align: center">${msg}</h1>
</body>
</html>