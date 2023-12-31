<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
	<style type="text/css">
	body{
		
		font-family: 'Poppins', sans-serif;
	}
	.container {
				display:flex;
			  	margin: 20px;
			  	padding: 20px;
			  	
		}
	.div1{
		flex-direction:inherit;
		height: 100%;
		  width: 80%;
		  text-align: center;
		  
		  position: fixed;
		  z-index: 1;
		  top: 0;
		  right: 0;
		  background-color:  ;
		  overflow-x: hidden;
	}
		.navbar {
		  height: 100%;
		  width: 20%;
		  position: fixed;
		  z-index: 1;
		  top: 0;
		  left: 0;
		  background-color: #191919;
		  color: white;
		  font-weight:500;
		  overflow-x: hidden;
		  padding-top: 20px;
		  
		}
		
		.navbar a {
		  font-size: 0.8em;
		  display: block;
		  color:white;
		  padding: 0.9em;
		  text-decoration: none;
		  font-weight: 500;
		}
		
		.navbar a:hover {
		  background-color: skyblue;
		  color: black;
		}
		
		.active {
		  color: gray;
		}
		
	
		.card {
			  display:inline-block;
			  text-align: center;
			  align-content:center;
			    overflow: hidden;
			  
			  border-radius: 10px ;
			  margin: 5px;
			  width: 45%;
			  height: 50%;
			  text-align:;
			  background-color: #f2f2f2;
			  text-decoration: none;
			  color: black ;
			  font-weight: 300;
			  font-size: 1em;
		}
		.card p{
			font-size:0.8em;
			text-align: justify;
			padding: 10px;
			padding: 20px;
		}
		.card h1{
			font-family: 'Cinzel', serif;
		}
		.card h4{
			font-weight: 400;
		}
		
		
		
	#search {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
        width: 75%;
        margin: 0 auto;
      }

      #search-btn {
        background-color: skyblue;
        color: black;
        border: none;
        border-radius: 5px;
        padding: 10px;
        font-size: 16px;
        cursor: pointer;
      }
      .search-header {
	  text-align: center;
	  margin: 20px;
}	

		.search-header h1{
			font-weight: 400;
		}
		
		
	</style>
</head>
<body class="texte">
<div class="container">
	<div class="navbar">
			<h2 id="texte">Fonctionnalités:</h2>
		  <a href="/Bibliotheque/Servlet/ConsulterNouveaute" target="_blank" >Consulter les nouveautés</a>
		  <a href="/Bibliotheque/Servlet/ajouterOuvrage" target="_blank">Ajouter des ouvrages</a>
		  <a href="/Bibliotheque/Servlet/consulterOuvrage" target="_blank">Consulter un ouvrage</a>
		  <a href="/Bibliotheque/rechercherOuvrageModifier.jsp" target="_blank">Modifier un ouvrage</a>
		  <a href="/Bibliotheque/Servlet/SupprimerOuvrage" target="_blank">Supprimer un ouvrage</a>
		  
		  
		  <a href="/Bibliotheque/AjouterUNmembre.jsp" target="_blank">Ajouter des membres</a>
		  <a href="/Bibliotheque/Servlet/ConsulterMembre" target="_blank">Consulter un membre</a>
		  <a href="/Bibliotheque/Servlet/SupprimerMembre" target="_blank">Supprimer un membre</a>
		  <a href="/Bibliotheque/Servlet/RechercherMembre" target="_blank">Modifier un membre</a>
		  
		  
		  <a href="/Bibliotheque/Servlet/AjouterEmprunt" target="_blank">Ajouter des emprunts</a>
		  <a href="/Bibliotheque/Servlet/ConsulterEmprunt" target="_blank">Consulter un emprunt</a>
		  <a href="/Bibliotheque/Servlet/SupprimerEmprunt" target="_blank">Supprimer un emprunt</a>
		  <a href="/Bibliotheque/rechercherEmpruntModifier.jsp" target="_blank">Modifier un emprunt</a>
		  
		  <a href="/Bibliotheque/Servlet/AjouterPenalite" target="_blank">Ajouter une pénalité</a>
		  <a href="/Bibliotheque/Servlet/SupprimerPenalite" target="_blank">Supprimer une pénalité</a>
		  <a href="/Bibliotheque/Servlet/ConsulterPenalites" target="_blank">Consulter la liste des pénalités</a>
		  
		  <a href="/Bibliotheque/Servlet/MaxEmprunter" target="_blank">Définir le max ouvrage à emprunter</a>
		  <a href="/Bibliotheque/Servlet/OuvragesPopulaires" target="_blank">Consulter les ouvrages populaires</a>
		  <a href="/Bibliotheque/Servlet/ConsulterOuvrageMoinsEmprunter" target="_blank">Consulter l'ouvrage le moins emprunté</a>
		  
		</div>
		<div class="div1">
			<div class="search-header">
				  <h1 id="texte"> Liste des ouvrage</h1>
				  <form action="Servlet/consulterOuvrage" method="post">
				      <input type="text" id="search" name="titre" placeholder="Recherche par titre de l'ouvrage...">
				      <button type="submit" id="search-btn">Rechercher</button>
			   	 </form>
			</div>
			
			<div>
				<c:forEach var="ouvrage" items="${sessionScope.ouvrages}">
		 			 <div class="card">
						<h1>``${ouvrage.titre}``</h1>
						<h4>Auteur : ${ouvrage.auteur}</h4>
						<p> ${ouvrage.description}</p>
					</div>
				</c:forEach>
			</div>
	</div>
</body>
</html>