<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajouter Ouvrage</title>
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
	<h1>Ajouter Ouvrage</h1>
	<form method="post" action="Servlet/ajouterOuvrage">
		<label>Titre :</label>
		<input type="text" name="titre"><br>
		<label>Auteur :</label>
		<input type="text" name="auteur"><br>
		<label>Description :</label>
		<textarea name="description"></textarea><br>
		<label>Nombre d'exemplaires :</label>
		<input type="number" name="nbExemplaires" min="1"><br>
		<input type="submit" value="Ajouter">
	</form>
	</div>
</body>
</html>
