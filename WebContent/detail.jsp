<%@page import="pack.ContreMesure"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<%@page import="pack.Vulnerabilite"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Detail</title>
<link rel="stylesheet" href="style.css" />
<%
	Vulnerabilite vul = new Vulnerabilite();
ResultSet rsv = vul.detailVul(Integer.parseInt(request.getParameter("idV")));
%>

<%
	ContreMesure cm = new ContreMesure();
ResultSet rsc = cm.detail(Integer.parseInt(request.getParameter("idV")));
%>
</head>
<body>
	<%@include file="/WEB-INF/include/header.jsp"%>
	<br>
	<br>
	<section id="generalite">

		<%
			while (rsv.next()) {
		%>
		<div style="width: 600px">
			<div class="card-body">
				<h2 class="card-title">
					Titre :
					<%=rsv.getString("titre")%></h2>
				<br>
	</section>
	<section id="gravite">
		<h3>
			<span id="red">Gravite</span>
		</h3>
		<p class="card-text">
			<SPAN STYLE="text-decoration: underline">Gravité :</SPAN>
			<%=rsv.getInt("gravite")%></p>
	</section>
	<aside id="Logiciel">
		<h3>
			<span id="blue">Logiciels</span>
		</h3>
		<p class="card-text">
			<SPAN STYLE="text-decoration: underline">Logiciel(s)
				impacté(s) :</SPAN>
			<%=rsv.getString("logiciels")%></p>
	</aside>
	<br>
	<section id="description">
		<h3>
			<span id="black">Description</span>
		</h3>
		<p class="card-text">
			<SPAN STYLE="text-decoration: underline">Description :</SPAN> <br>
			<%=rsv.getString("description")%></p>
	</section>
	</div>
	</div>
	<br>
	<%
		}
	%>
	<section id="CM">
		<h2>Contre-Mesure</h2>
		<%
			while (rsc.next()) {
		%>
		<div style="width: 600px">
			<div class="card-body">
				<h5 class="card-title"><%=rsc.getString("cm.titre")%></h5>
				<p class="card-text">
					<%=rsc.getString("cm.description")%></p>
				<p class="card-text">
					<SPAN STYLE="text-decoration: underline"> Sources :</SPAN>
					<%=rsc.getString("cm.sources")%></p>
			</div>
		</div>
		<br>
		<%
			}
		%>

	</section>
	<%@include file="/WEB-INF/include/footer.jsp"%>

</body>
</html>