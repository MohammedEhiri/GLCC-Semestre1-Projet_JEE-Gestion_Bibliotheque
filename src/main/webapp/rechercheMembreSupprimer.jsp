<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Rechercher un membre à supprimer</title>
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
			  <h1>Supprimer un membre</h1>
			  <form action="SupprimerMembre" method="post">
			      <input type="email" id="search" name="email" placeholder="Recherche par email...">
			      <button type="submit" id="search-btn">Supprimer</button>
		   	 </form>
		</div>
	
  </body>
</html>




