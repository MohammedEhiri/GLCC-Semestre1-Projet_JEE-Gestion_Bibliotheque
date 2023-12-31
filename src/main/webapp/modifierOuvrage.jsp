<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Ouvrage</title>
</head>
<body>
    <h1>Modifier Ouvrage</h1>
    
    
    <form method="post" action="Servlet/modifierOuvrage" >
   	 <input type="hidden" name="id" value="${ouvrage.id}" />

			<label for="titre">Titre :</label>
			<input type="text" name="titre" value="${ouvrage.titre}" required>

			<label for="auteur">Auteur :</label>
			<input type="text" name="auteur" value="${ouvrage.auteur}" required>

			<label for="description">Description :</label>
			<input type="text" name="description" value="${ouvrage.description}" required>

			<label for="nbExemplaires">Auteur :</label>
			<input type="text" name="nbExemplaires" value="${ouvrage.nbExemplaires}" required>

			<input type="submit" value="Modifier">

	</form>
	
	
	
</body>
</html>
