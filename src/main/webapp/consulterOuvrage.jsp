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
		font-family: 'Poppins', sans-serif;
	}


 body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }
	table {
		display:inline-block;
			  
			  border-radius: 5px ;
			  margin: 5px;
			  padding: 10px;
			  width: 80%;
			  height: 50%;
			  background-color: #f2f2f2;
			  text-decoration: none;
			  color: ;
			  font-size: 16px;
			  font-weight: 400;
		}
		td,th{
			padding: 20px;
			font-size: 1em;
			text-align: justify;
		}
		.search-header {
			text-align: center;
			margin: 20px;
		}	
</style>

</head>
<body>
<div class="search-header">
    <h1 id="texte">Informations sur l'Ouvrage</h1>
    <table>
        <tr>
            <th>Titre: </th>            
            <td><c:out value="${ouvrage.getTitre()}" /></td>
        </tr>
        <tr>
            <th>Auteur: </th>
            <td><c:out value="${ouvrage.getAuteur()}" /></td>
        </tr>
        <tr>
            <th>Description: </th>
            <td><c:out value="${ouvrage.getDescription()}" /></td>
        </tr>
        <tr>
            <th>Nombre d'exemplaires: </th>
            <td><c:out value="${ouvrage.getNbExemplaires()}" /></td>
        </tr>
    </table>
    </div>
</body>
</html>
