<%@page import="pack.ContreMesure"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="pack.Vulnerabilite"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ModifContreMesure</title>
</head>
<header>
	<h1>Modification Contre Mesure</h1>
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
		<!-- Grace aux scriplets dans "value" je les donnes les informations a modifier -->
		<div>

			Descripton:<input type="text" class="form-control"
				aria-label="With textarea" name="description"
				value="<%=request.getParameter("description")%>"> <br />

			Sources:<input type="text" class="form-control"
				aria-label="With textarea" name="sources"
				value="<%=request.getParameter("sources")%>"> <br />

		</div>
		<input type="hidden" name="IdC"
			value="<%=request.getParameter("IdC")%>"> <input
			type="hidden" name="IdV" value="<%=request.getParameter("IdV")%>">
		<input type="hidden" name="titre"
			value="<%=request.getParameter("titre")%>"> <input
			type="submit" value="soumettre">
	</form>
</body>
</html>