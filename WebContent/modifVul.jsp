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
	<form action="ServletVulnerabilite" method="post">

		<label>Vulnérabilité </label>
		<!-- Grace aux scriplets dans "value" je les donnes les informations a modifier		 -->
		<div>
			Titre:<input type="text" class="form-control"
				aria-label="With textarea" name="titre"
				value="<%=request.getParameter("titre")%>"> <br />
			Synthese:<input type="text" class="form-control"
				aria-label="With textarea" name="synthese"
				value="<%=request.getParameter("synthese")%>"> <br />
			Descripton:<input type="text" class="form-control"
				aria-label="With textarea" name="description"
				value="<%=request.getParameter("description")%>"> <br />
			Gravité:<input type="text" class="form-control"
				aria-label="With textarea" name="gravite"
				value="<%=request.getParameter("gravite")%>"> <br />
			Logiciels:<input type="text" class="form-control"
				aria-label="With textarea" name="logiciels"
				value="<%=request.getParameter("logiciels")%>"> <br />

		</div>

		<input type="submit" value="soumettre"> <input type="hidden"
			name="IdV" value="<%=request.getParameter("IdV")%>">
	</form>



</body>
</html>