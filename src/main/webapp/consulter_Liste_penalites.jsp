<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des pénalités</title>
	
</head>
<body>
	<h1>Liste des pénalités</h1>
	
	<c:if test="${empty penalites}">
		<p>Aucune pénalité trouvée.</p>
	</c:if>
	
	<c:if test="${not empty penalites}">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>ID de l'emprunt</th>
					<th>Montant</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="penalite" items="${penalites}">
					<tr>
						<td>${penalite.id}</td>
						<td>${penalite.idEmprunt}</td>
						<td>${penalite.montant}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<p><a href="index.jsp">Retour à l'accueil</a></p>
</body>
</html>
