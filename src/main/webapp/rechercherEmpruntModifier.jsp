<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Recherche un membre</title>
    
    
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    
    
    <style>
      body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }

      #search {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
        width: 400px;
        margin: 0 auto;
      }

      #search-btn {
        background-color: blue;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 10px;
        font-size: 16px;
        cursor: pointer;
      }
      .search-header {
  text-align: center;
  margin-top: 20px;
}
      
    </style>
  </head>
  <body>
         <div class="search-header">
			  <h1>Rechercher un emprunt</h1>
			  <form action="Servlet/ModifierEmprunt" method="get">
			      <input type="number" id="search" name="id" placeholder="Id de l'emprunt...">
			      <button type="submit" id="search-btn">Rechercher</button>
		   	 </form>
		</div>
	
    

  </body>
</html>




