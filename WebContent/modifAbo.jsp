<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="pack.Vulnerabilite"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ModifierVul</title>
</head>
<header>
	<h1>Modification de Vulnerabilite</h1>
	<!-- 	instansation et appelle de la méthode read -->
	<%
		Vulnerabilite v = new Vulnerabilite();
	ResultSet rs = v.read();
	%>
</header>
<%@ include file="WEB-INF/include/admNavBar.jsp"%>
<body>
	<form action="ServletAbonne" method="post">

		<label>Abonné </label>
		<!-- Grace aux scriplets dans "value" je les donnes les informations a modifier		 -->
		<div>
			Nom:<input type="text" class="form-control"
				aria-label="With textarea" name="nom"
				value="<%=request.getParameter("nom")%>" disabled="disabled">
			<br /> Prenom:<input type="text" class="form-control"
				aria-label="With textarea" name="prenom"
				value="<%=request.getParameter("prenom")%>" disabled="disabled">
			<br /> Email:<input type="mail" class="form-control"
				aria-label="With textarea" name="email"
				value="<%=request.getParameter("email")%>"> <br />

		</div>

		<input type="submit" value="Modifier"> <input type="hidden"
			name="IdA" value="<%=request.getParameter("IdA")%>">
	</form>



</body>
</html>