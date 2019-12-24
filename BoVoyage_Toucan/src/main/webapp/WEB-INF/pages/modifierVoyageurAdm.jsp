<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <!--  ajouter la taglib form de srping -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>Modification voyageur</title>

<!--  lier le fichier css � ma page car boostrap ne se trouve pas dans le m�me fichier que ma page -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>"/>

</head>


<h1 style="color: red; text-align: center;">Formulaire de modification</h1>

	<form method="get" action="modifVoyageur">
	
Id : <input type="number" name="pId" />
		<br/>
Nom : <form:input type="text" path="nom" /> 
		<br />
Pr�nom: <form:input type="text" path="prenom" />
		<br />
Date: <form:input type="date" path="dn" />
		<br />
Num�ro de si�ge:<form:input type="number" path="numSiege" /> 			
		<br />
Num�ro de dossier : <form:input type="number" path="dossier" /> 	
		<br />
Adresse :<form:input type="number" path="adresse" /> 	
<br />
T�l�phone :<form:input type="number" path="telephone" /> 	
<br />
Nationalit�:<form:input type="number" path="nationalite" /> 		
		
<br/>
<br />
		<input class="btn btn-warning" type="submit" value="modifier">
	</form>

	<h1 style="color: red; text-align: center;">${msg}</h1>





<body>

</body>
</html>