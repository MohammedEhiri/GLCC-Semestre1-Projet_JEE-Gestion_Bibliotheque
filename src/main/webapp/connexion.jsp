<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Connexion bibliothécaire</title>
	
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
		input[type="text"], input[type="password"], select {
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
			color:black;
		}
	</style>
</head>
<body>
	<div class="container">
	<h1>Connexion bibliothécaire</h1>
	<form method="POST" action="ConnexionBibliothecaire">
		<label for="username">Nom d'utilisateur :</label>
		<input type="text" id="username" name="username" required>
		<br>
		<label for="password">Mot de passe :</label>
		<input type="password" id="password" name="password" required>
		<br>
		<input type="submit" value="Se connecter">
	</form>
	</div>
</body>
</html>
