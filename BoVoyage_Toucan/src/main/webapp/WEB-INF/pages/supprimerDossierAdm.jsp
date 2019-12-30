<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Ajouter la lib fmt de jstl qui sert a l'internationalisation de mon app -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Suppression Dossier</title>

<!--  lier le fichier css à ma page car boostrap ne se trouve pas dans le même fichier que ma page -->
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>" />
<link rel="stylesheet" href="<c:url value='/assets/css/BoVoyageStyle.css'/>"/>

</head>



<body>
<!--  inclure le header -->
	<%@include file="/templates/header.html"%>
<h1 id="titre">Suppression des dossiers clients via le numéro de dossier</h1>
<br />
	<%@include file="/templates/menuAdm.html"%>

	Id : <input type="number" name="pId" /> 
	
<!--  inclure le footer -->
	<%@include file="/templates/footer.html"%>

</body>
</html>