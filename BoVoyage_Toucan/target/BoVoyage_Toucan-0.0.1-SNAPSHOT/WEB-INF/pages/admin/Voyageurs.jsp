<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Ajouter la lib fmt de jstl qui sert a l'internationalisation de mon app -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
  
  
 
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Liste des voyageurs</title>

<!--  lier le fichier css � ma page car boostrap ne se trouve pas dans le m�me fichier que ma page -->
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>"/>


</head>


<body>

<table class="table table-bordered">
		<tr>
			<th>Nom</th>
			<th>Pr�nom</th>
			<th>Num�ro de si�ge</th>
			<th>Num�ro de dossier</th>
			<th>Date de naissance</th>
			<th>Adresse</th>
			<th>T�l�phone</th>
			<th>Natiolnalit�</th>
			<th>Op�rations</th>
		</tr>

		<c:forEach var="v" items="${etudiants}">
			<tr>
				<td>${e.id}</td>
				<td>${e.nom}</td>
				<td>${e.prenom}</td>
				<td><fmt:formatDate value="${e.dn}" pattern="dd/MM/yyyy"/> </td>
				
				<!-- pour supprimer directement l'�tudiant on va mettre son param�tre pId et ${e.id}.
				comme �a il nenous envoie pas sur la page mais supprime direct l'�tudiant.-->
				<td><a href="<c:url value='/ecole/submitDelete?pId=${e.id}'/>"><b>Supprimer</b></a> |
				<a href="<c:url value='/ecole/linkUpdate?pId=${e.id}'/>"><b>Modifier</b></a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>