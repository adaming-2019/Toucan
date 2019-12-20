<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <!-- Ajouter la taglib form de spring -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <!-- Ajouter la lib core de jstl -->
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voyages</title>
	<!--  Lier le fichier css de bootstrap à ma page -->
	<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>"/>
</head>
<body>

	<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>DateDebut</th>
			<th>DateRetour</th>
			<th>NombrePlace</th>
			<th>PrixAgence</th>
			<th>PrixBoVoyage</th>
			<th>Statut</th>
			<th>Photos</th>
		</tr>

		<c:forEach var="v" items="${voyages}">
			<tr>
				<td>${e.id}</td>
				<td>${e.dateDebut}</td>
				<td>${e.dateRetour}</td>
				<td>${e.nombrePlace}</td>
				<td>${e.prixAgence}</td>
				<td>${e.prixBoVoyage}</td>
				<td>${e.statut}</td>
				<td>${e.photos}</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>