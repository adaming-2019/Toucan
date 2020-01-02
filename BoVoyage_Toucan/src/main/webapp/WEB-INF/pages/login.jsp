<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>

<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/assets/css/BoVoyageStyle.css' />" />

</head>
<body>
<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
	
	<h2 id="titre">Connexion à votre compte</h2>

	<form class="form-horizontal" method="POST"
		action="#">
		<div class="form-group">
			<label class="control-label col-sm-4">Login : </label>
			<div class="col-sm-2">
				<input type="text" class="form-control"
					name="pLogin" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-4">Mot de passe : </label>
			<div class="col-sm-2">
				<input type="password" class="form-control"
					name="pMdp" />
			</div>
		</div>

		<input class="btn btn-primary" type="submit" value="Se connecter" />
	</form>
	
	<h4 style="color: red; text-align: center;">${msg}</h4>

	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>

</body>
</html>