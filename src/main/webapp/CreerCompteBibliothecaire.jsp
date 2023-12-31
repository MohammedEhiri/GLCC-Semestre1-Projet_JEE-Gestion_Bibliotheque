<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		font-family: Arial, Helvetica, sans-serif;
		background-color: #f2f2f2;
	}
	
	h1 {
		text-align: center;
		color: #333;
	}
	
	form {
		margin: auto;
		width: 50%;
		border: 3px solid #ddd;
		padding: 10px;
		background-color: #fff;
	}
	
	label {
		display: inline-block;
		width: 150px;
		font-weight: bold;
		margin-bottom: 10px;
	}
	
	input[type=text], input[type=password],input[type=email] {
		width: 70%;
		padding: 12px 20px;
		margin: 8px 0;
		border: 1px solid #ccc;
		border-radius: 4px;
		box-sizing: border-box;
	}
	
	input[type=submit] {
		background-color: #4CAF50;
		color: white;
		padding: 14px 20px;
		margin: 8px 0;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	input[type=submit]:hover {
		background-color: #45a049;
	}
</style>
</head>
<body>
	<form action=Servlet/ajouterBibliothecaire method="post">
	<label for="nom">Nom :</label>
	<input type="text" id="nom" name="nom" required><br><br>
	
	<label for="prenom">Prénom :</label>
	<input type="text" id="prenom" name="prenom" required><br><br>
	
	<label for="email">Email :</label>
	<input type="email" id="email" name="email" required><br><br>
	
	<label for="username">Nom d'utilisateur :</label>
	<input type="text" id="username" name="username" required><br><br>
	
	<label for="password">Mot de passe :</label>
	<input type="password" id="password" name="password" required><br><br>
	
	<input type="submit" value="Créer un compte">
</form>
	
</body>
</html>