<%@page import="pack.Abonne"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="pack.Vulnerabilite"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreationAbo</title>
</head>
<header>
	<h1>Ajout de Vulnerabilité</h1>
	<!-- 	instansation et appelle de la méthode read -->
	<%
		Abonne a = new Abonne();
	ResultSet rs = a.read();
	%>
</header>
<%@ include file="WEB-INF/include/admNavBar.jsp"%>
<body>

	<form action="ServletAbonne" method="post">



		<div>

			<!-- 		Pour ajouter une vulnerabilité il faut que dans ma servletvulnerabilite ça rentre dans le else -->
			<!-- 		donc il me faut un IdV=0. Si on fait un input type="text" name="IdV" il faudra rentrer a la main -->
			<!-- 		le numero zero pour pouvoir rentrer dans le else. Donc j'ai fait un input hidden avec name="IdV" -->
			<!-- 		et je lui donne la valeur zero. De cette façon on ne voir pas ce champs dans le formulaire et -->
			<!-- 		on envoi bien un IdV=0 -->
			<input type="hidden" name="IdA" value=0> <br />
			<div>
				Nom:<input type="text" class="form-control"
					aria-label="With textarea" name="nom"> <br /> Prenom:<input
					type="text" class="form-control" aria-label="With textarea"
					name="prenom"> <br /> Email:<input type="mail"
					class="form-control" aria-label="With textarea" name="email">
				<br />

			</div>

			<input type="submit" value="Créer">
	</form>

</body>
</html>