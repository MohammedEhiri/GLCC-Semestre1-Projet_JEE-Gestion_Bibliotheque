<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajouter une pénalité</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
		}
		.container {
			display: flex;
			flex-direction: column;
			align-items: center;
			margin-top: 50px;
		}
		.form {
			display: flex;
			flex-direction: column;
			align-items: center;
			background-color: #f2f2f2;
			padding: 20px;
			border-radius: 10px;
			box-shadow: 0 0 10px rgba(0,0,0,0.2);
			width: 40%;
		}
		h1 {
			margin-bottom: 20px;
		}
		label {
			font-weight: bold;
			margin-bottom: 10px;
		}
		input[type="date"], input[type="number"],input[type="text"],textarea, select {
			width: 100%;
			padding: 10px;
			margin-bottom: 20px;
			border-radius: 5px;
			border: none;
			box-shadow: 0 0 5px rgba(0,0,0,0.2);
		}
		input[type="submit"] {
		
			background-color: blue;
			color: white;
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}
		input[type="submit"]:hover {
			background-color: skyblue;
			color: black;
		}
	</style>
</head>
<body>
<div class="container">

	<h1>Ajouter une pénalité</h1>
	<c:if test="${not empty errorMessage}">
		<p style="color: red">${errorMessage}</p>
	</c:if>
	<form action="AjouterPenalite" method="post">
		<label for="idEmprunt">ID de l'emprunt:</label>
		<input type="number" id="idEmprunt" name="idEmprunt" required="required"><br><br>
		
		<label for="montant">Montant de la pénalité:</label>
		<input type="number" id="montant" name="montant" required="required"><br><br>
		
		<label for="montant">Date de début de la pénalité:</label>
		<input type="date" id="dateDebut" name="dateDebut" required="required"><br><br>
		
		<label for="montant">Date de fin de la pénalité:</label>
		<input type="date" id="dateFin" name="dateFin" required="required"><br><br>
		
		<input type="submit" value="Ajouter">
	</form>
	</div>
</body>
</html>
