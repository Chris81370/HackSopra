<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="pack.Vulnerabilite"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreationVul</title>
</head>
<header>
	<h1>Ajout de Vulnerabilité</h1>
<!-- 	instansation et appelle de la méthode read -->
	<%
	Vulnerabilite v = new Vulnerabilite();
	ResultSet rs = v.read();
	%>
</header>
<%@ include file="WEB-INF/include/admNavBar.jsp"%>
<body>
	
	<form action="ServletVulnerabilite" method="post">
	
	
		
		<div>

<!-- 		Pour ajouter une vulnerabilité il faut que dans ma servletvulnerabilite ça rentre dans le else -->
<!-- 		donc il me faut un IdV=0. Si on fait un input type="text" name="IdV" il faudra rentrer a la main -->
<!-- 		le numero zero pour pouvoir rentrer dans le else. Donc j'ai fait un input hidden avec name="IdV" -->
<!-- 		et je lui donne la valeur zero. De cette façon on ne voir pas ce champs dans le formulaire et -->
<!-- 		on envoi bien un IdV=0 -->
		<input type="hidden" name="IdV" value=0>
		<br/>
		<div>
		Titre:<input type="text" class="form-control" aria-label="With textarea" name="titre"
		>
		<br/>
		Synthese:<input type="text" class="form-control" aria-label="With textarea" name="synthese"
		>
		<br/>
		Descripton:<input type="text" class="form-control" aria-label="With textarea" name="description" 
		>
		<br/>
		Gravité:<input type="text" class="form-control" aria-label="With textarea" name="gravite"
		>
		<br/>
		Logiciels:<input type="text" class="form-control" aria-label="With textarea" name="logiciels"
		>
		<br/>

		</div>
		
		<input type="submit" value="soumettre">
	</form>
	
</body>
</html>