<%@page import="com.mysql.jdbc.ResultSet"%>
<%@page import="pack.Abonne"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admConf</title>
<%
	Abonne a = new Abonne();
ResultSet rs = a.read();
%>
</head>
<header>
	<h1>Configuration</h1>
</header>
<%@ include file="WEB-INF/include/admNavBar.jsp"%>
<body>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Frequence d'envoi</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<button type="button" class="btn btn-info">Immédiat</button>
					<button type="button" class="btn btn-info">Fin de journée</button>
					<button type="button" class="btn btn-info">Fin de semaine</button>
					<button type="button" class="btn btn-info">Fin de mois</button>
				</td>
			</tr>
		</tbody>
	</table>
	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Mail</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				while (rs.next()) {
			%>
			<tr>
				<th scope="row"><%=rs.getInt("IdA")%></th>
				<td><%=rs.getString("email")%></td>


				<td>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-warning" data-toggle="modal"
						data-target="#exampleModal">Modifier</button>
				</td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<%@ include file="WEB-INF/include/footer.jsp"%>
</body>
</html>