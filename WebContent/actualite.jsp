<%@page import="com.mysql.jdbc.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="pack.Vulnerabilite"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Actualités</title>

<%
	Vulnerabilite vul = new Vulnerabilite();
ResultSet rs = vul.read();
%>
</head>
<body>
	<%@include file="/WEB-INF/include/header.jsp"%>
	<h2>Historique des actualités</h2>

	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">titre</th>
				<th scope="col">synthese</th>
				<th class="bg-danger" scope="col">gravite</th>
				<th scope="col">information</th>

			</tr>
		</thead>


		<%
			while (rs.next()) {
		%>
		<tr>
			<th scope="row"><%=rs.getInt("idV")%></th>

			<td><%=rs.getString("titre")%></td>
			<td><%=rs.getString("synthese")%></td>
			<td><%=rs.getString("gravite")%></td>
			<td><a class="btn btn-outline-warning"
				href="detail.jsp?idV=<%=rs.getInt("idV")%>">Détail</a></td>

		</tr>
		<%
			}
		%>

	</table>
	<%@include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>