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
<title>Contact</title>
<!-- Lier lb bootstrap à ma page -->
<link rel="stylesheet" href="../assets/css/bootstrap.css" />
<link rel="stylesheet" href="../assets/css/BoVoyageStyle.css" />
</head>
<body>
	<!--  inclure le header -->
	<%@include file="/templates/header.html"%>

	<div class="container">
		<h1 id="titre">Veulliez remplir ce formulaire afin de nous
			contacter</h1>
		<hr class="f4" />
	</div>
	<div class="row">
		<form:form class="container form-inline" method="POST"
			modelAttribute="contact" action="contact/sendSimpleEmail">
			<label class="col-md-2" for="name">Nom :</label>
			<form:input class="col-md-10" id="name" path="name" />
			<br />
			<br />
			<label class="col-md-2" for="email">E-mail :</label>
			<form:input class="col-md-10" id="email" path="email" />
			<br />
			<br />
			<label class="col-md-2" for="subject">Objet :</label>
			<form:input class="col-md-10" id="subject" path="subject" />
			<br />
			<br />
			<label class="col-md-2" for="message">Votre message :</label>
			<form:textarea class=" col-md-10" id="message" rows="5" path="text"></form:textarea>
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />

			<div class="col-md-2"></div>
			<div class="col-md-1">
				<input class="btn btn-success" type="submit" value="Envoyer">
			</div>

		</form:form>
	</div>
	<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>
</body>
</html>