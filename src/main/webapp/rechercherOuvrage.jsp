<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Rechercher un Ouvrage</title>
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
			  <h1>Rechercher un Ouvrage</h1>
			  <form action="Servlet/consulterOuvrage" method="post">
			      <input type="text" id="search" name="titre" placeholder="Recherche par Titre...">
			      <button type="submit" id="search-btn">Rechercher</button>
		   	 </form>
		</div>
	
  </body>
</html>




