<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChoixProprioAppart</title>
</head>
<body>
	<form method="post" action="">
		<label for="proprioId">Nom du propriétaire</label><select name="proprioId" id="proprioId">
		<!-- debut de la construction du menu des proprios -->
			${ optionproprio }
		<!-- fin de la construction du menu des proprios -->
		</select>
		<input type="submit" value="Envoyer">	
	</form>
		<p> ${ nologement } </p>
	<form style="display: ${ visibilite }" method ="post" action="enregistrerpropriete">
		<label for="logementId">Adresse du logement</label><select name="logementId" id="logementId">
		${ optionlogement }
		</select>
		<div><p>1er jour de disponibilité : </p>
		<label for="jourDebut" > jour :</label><select name="jourDebut" id="jourDebut">
		${ optionjour }
		</select>
		<label for="moisDebut" > mois :</label><select name="moisDebut" id="moisDebut">
		${ optionmois }
		</select>
		<label for="anneeDebut" > Année :</label><select name="anneeDebut" id="anneeDebut">
		${ optionans }
		</select>
		</div>
		<div><p>Dernier jour de disponibilité : </p>
		<label for="jourFin" > jour :</label><select name="jourDebut" id="jourDebut">
		${ optionjour }
		</select>
		<label for="moisFin" > mois :</label><select name="moisDebut" id="moisDebut">
		${ optionmois }
		</select>
		<label for="anneeFin" > Année :</label><select name="anneeDebut" id="anneeDebut">
		${ optionans }
		</select>
		</div>
		<input style="display: ${ visibilite }" type="submit" value="Enregistrer">
	</form>
</body>
</html>