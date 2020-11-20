<%@page import="pack.ContreMesure"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="pack.Vulnerabilite"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreationContreMesure</title>
</head>
<header>
	<h1>Creation Contre Mesure</h1>
	<!-- 	instansation et appelle de la méthode read -->
	<%
		ContreMesure c = new ContreMesure();
	ResultSet rs = c.read();
	%>
</header>
<%@ include file="WEB-INF/include/admNavBar.jsp"%>
<body>
	<form action="ServletContreMesure" method="post">

		<label>Contre Mesure </label>
		<!-- Grace aux scriplets dans "value" je les donnes les informations a modifier		 -->
		<div>
			# Vulnérabilité<input type="text" name="IdV" disabled="disabled"
				value="<%=request.getParameter("IdV")%>"><br> Titre:<input
				type="text" class="form-control" aria-label="With textarea"
				name="titre" value="<%=request.getParameter("titre")%>"> <br />

			Descripton:<input type="text" class="form-control"
				aria-label="With textarea" name="description"
				value="<%=request.getParameter("description")%>"> <br />

			Sources:<input type="text" class="form-control"
				aria-label="With textarea" name="sources"
				value="<%=request.getParameter("logiciels")%>"> <br />

		</div>

		<input type="submit" value="soumettre">
	</form>



</body>
</html>