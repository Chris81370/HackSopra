<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="pack.Vulnerabilite"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<link rel="stylesheet" href="style.css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Accueil</title>
<%
	Vulnerabilite vul = new Vulnerabilite();
ResultSet rs = vul.select();
%>
</head>
<body>
	<%@include file="/WEB-INF/include/header.jsp"%>
	<h2>Flash sur les dernières Vulnérabilités</h2>


	<%
		while (rs.next()) {
	%>

	<div class="card text-white bg-secondary mb-3" style="width: 600px">
		<div class="card-body">
			<h5 class="card-title"><%=rs.getString("titre")%></h5>
			<p class="card-text"><%=rs.getString("synthese")%></p>
			<p class="card-text">
				Logiciel impacté :
				<%=rs.getString("logiciels")%></p>
			<p class="card-text">
				Gravité :
				<%=rs.getInt("gravite")%></p>
			<div align="right">
				<a href="detail.jsp?idV=<%=rs.getString("idV")%>"
					class="btn btn-primary">Détails</a>
			</div>
		</div>
	</div>
	<br>

	<%
		}
	%>

	<%@include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>