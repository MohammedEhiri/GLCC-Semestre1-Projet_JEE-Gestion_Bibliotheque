<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajouter un membre</title>
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
		input[type="text"], input[type="email"], input[type="password"], select {
			width: 100%;
			padding: 10px;
			margin-bottom: 20px;
			border-radius: 5px;
			border: none;
			box-shadow: 0 0 5px rgba(0,0,0,0.2);
		}
		button[type="submit"] {
			background-color: #4CAF50;
			color: white;
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}
		button[type="submit"]:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	
<div class="container">
		<h1>Modifier un membre</h1>
		<div class="form">
			<form action="Servlet/ModifierMembre" method="post">
				<label for="typeMembre">Type de membre :</label>
				<select name="type" id="typeMembre">
					<option value="etudiant">Étudiant</option>
					<option value="personnel">Personnel de la faculté</option>
					<option value="enseignant">Enseignant</option>
				</select>
				<label for="nom">Nom :</label>
				<input type="text" name="nom" value="${membre.getNom() }" id="nom" required>
				<label for="prenom">Prénom :</label>
				<input type="text" name="prenom" value="${membre.getPrenom() }" id="prenom" required>
				<label for="email">Email :</label>
				<input type="email" name="email" value="${membre.getEmail() }" id="email" required>
				<label for="email">Mot de passe :</label>
				<input type="password" name="password" value="${membre.getPassword() }" id="password" required>
				<button type="submit">Modifier</button>
				</form>
		</div>
	</div>
</body>
</html>
