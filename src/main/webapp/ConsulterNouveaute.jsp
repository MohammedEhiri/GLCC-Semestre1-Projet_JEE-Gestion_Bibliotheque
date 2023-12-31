<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulter Ouvrage</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
		
	

	<style type="text/css">
	
	*{
		
	}
	
	.div1{
		flex-direction:inherit;
		height: 100%;
		  width: 100%;
		  text-align: center;
		  
		  position: fixed;
		  z-index: 1;
		  top: 0;
		  right: 0;
		  background-color:  ;
		  overflow-x: hidden;
	}
	
		.card {
			  display:inline-block;
			  text-align: center;
			  align-content:center;
			    overflow: hidden;
			  
			  border: 1px solid black;
			  border-radius: 10px ;
			  margin: 5px;
			  width: 42%;
			  height: 55%;
			  text-align:;
			  background-color: ;
			  text-decoration: none;
			  color: black ;
			  font-weight: 300;
			  font-size: 1em;
		}
		.card p{
			text-align: justify;
			padding: 10px;
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
			font-weight: 900;
			font-size: 4em;
		}
		
		
	
</style>

</head>
<body>
<div class="div1">

	
		<div class="search-header">
			  <h1>Nouveauté</h1>
			  <form action="Servlet/consulterOuvrage" method="post">
			      <input type="text" id="search" name="titre" placeholder="Recherche par titre de l'ouvrage...">
			      <button type="submit" id="search-btn">Rechercher</button>
		   	 </form>
		</div>
		
		
		<c:forEach var="ouvrage" items="${sessionScope.ouvrages}">
 			 <div class="card">
				<h1>"${ouvrage.titre}"</h1>
				
				<p>${ouvrage.description}</p>
				<h3>Auteur : ${ouvrage.auteur}</h3>
			</div>
		</c:forEach>
		
		
			
		</div>
		
		
		
			
	</div>

</body>
</html>
