<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un emprunt</title>
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
		input[type="date"], input[type="number"], select {
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
	    <h1>Ajouter un emprunt</h1>
	    <form method="post" action="AjouterEmprunt">
	        <label for="membreId">ID du membre :</label>
	        <input type="number" id="membreId" name="membreId" required><br><br>
	        <label for="idOuvrage">ID du Ouvrage :</label>
	        <input type="number" id="idOuvrage" name="idOuvrage" required><br><br>
	        <label for="dateEmprunt">Date d'emprunt :</label>
	        <input type="date" id="dateEmprunt" name="dateEmprunt" required><br><br>
	        <label for="dateRetour">Date de retour :</label>
	        <input type="date" id="dateRetour" name="dateRetour"><br><br>
	        <input type="submit" value="Ajouter">
	    </form>
	</div>
</body>
</html>
