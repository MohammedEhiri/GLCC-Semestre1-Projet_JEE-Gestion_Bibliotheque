<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Consulter un membre</title>
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
		<h1>Consulter un membre</h1>
		<div class="form">
			<form >
				<label for="typeMembre">Type de membre :</label>
				<input type="text" value="${membre.getType() }" id="nom">
				<label for="nom">Nom :</label>
				<input type="text" value="${membre.getNom() }" id="nom">
				<label for="prenom">Prénom :</label>
				<input type="text" value="${membre.getPrenom() }" id="prenom">
				<label for="email">Email :</label>
				<input type="email" value="${membre.getEmail() }" id="email">
		</div>
	</div>
</body>
</html>
