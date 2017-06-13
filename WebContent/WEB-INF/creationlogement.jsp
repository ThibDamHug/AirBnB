<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creation logement</title>
	</head>
	<body>
		<form method="post" action="">
			<label for="proprioId">Nom du propriétaire</label><select name="proprioId" id="proprioId">
			<!-- debut de la construction du menu des proprios -->
			<c:forEach var="proprio" items="${proprioList}" >
    			<option value=" ${proprio.id} " > ${proprio.nom} </option><br>
			</c:forEach>
			
			<!-- fin de la construction du menu des proprios -->
			</select>
			<label for="numerorue">Numéro de rue</label><input type="text" name="numerorue" id="numerorue" required/><span>${erreurs['numerorue']}</span>
			<label for="rue">Rue :</label><input type="text" name="rue" id="rue" required/><span>${erreurs['rue']}</span>
			<label for="ville">Ville :</label><input type="text" name="ville" id="ville" required/><span>${erreurs['ville']}</span>
			<label for="codepostal">Code postal:</label><input type="number" name="codepostal" id="codepostal" required/><span>${erreurs['codepostal']}</span>
			<label for="descriptionlogement">Description du logement:</label>
			<textarea name="descriptionlogement" id="descriptionlogement" rows="10" cols="50" required></textarea><span>${erreurs['codepostal']}</span>
			<input type="submit" value="Envoyer">	
		</form>
		<p> ${ resultat} </p>
	</body>
</html>