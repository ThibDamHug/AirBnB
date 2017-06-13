<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creation Proprietaire</title>
	</head>
	<!-- pattern="/^([a-z0-9._-]+)@([a-z0-9._-]+)\.([a-z]{2,6)$/" pattern="[0-9]{10}"-->
	<body>
		<form method="post" action="/nouvelenregistrement">
			<label for="nom">Nom du propriétaire</label><input type="text" name="nom" id="nom" required/><span>${erreurs['nom']}</span>
			</br>
			<label for="password">Mot de passe</label><input type="password" name="password" id="password" required/><span>${erreurs['password']}</span>
			</br>
			<label for="telephone">Numero de téléphone</label><input type="tel" name="telephone" id="telephone" pattern="^0[1-68]([-. ]?[0-9]{2}){4}$"  TITLE="La forme doit etre 0XXXXXXXXX ()" required/><span>${erreurs['telephone']}</span>
			</br>
			<label for="mail">e-mail</label><input type="email" name="mail" id="mail" required/><span>${erreurs['email']}</span>
			</br>
			<input type="submit" value="Enregistrer le proprietaire">
		</form>
		<p> ${ resultat} </p>
	</body>
</html>