<%@page import="com.mysql.jdbc.ResultSet"%>
<%@page import="pack.Abonne"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admGestion</title>
<%
	Abonne a = new Abonne();
ResultSet rs = a.read();
%>
</head>
<header>
	<h1>Liste des abonnés</h1>
</header>
<%@ include file="WEB-INF/include/admNavBar.jsp"%>
<body>
	<a href="CreationAbo.jsp" class="btn btn-success">Ajouter Abonné</a>
	<!-- Modal -->
	<div align="center"></div>
	<form action="ServletAbonne" method="get">
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" align="center">
						<h5 class="modal-title" id="exampleModalLabel">Ajouter
							Contre-mesure</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="ServletAbonne" method="post">
							<table class="table table-borderless">

								<tr>

									<td># Abonné</td>
									<td><input type="number" name="IdV"
										value="<%=session.getAttribute("IdA")%>"></td>
								</tr>
								<br>
								<tr>
									<td>Nom</td>
									<td><input type="text" class="form-control" name="nom"
										required></td>
								</tr>
								<br>
								<tr>
									<td>Prenom</td>
									<td><input type="text" class="form-control" name="prenom"
										required></td>
								</tr>
								<br>
								<tr>
									<td>Email</td>
									<td><input type="mail" class="form-control" name="email"
										required></td>
								</tr>
							</table>
							<input type="submit" class="btn btn-primary" value="Créer"></input>
						</form>

					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
	</form>
	</tbody>
	</table>
	<table class="table table-dark">
		<thead>
			<tr>

				<th scope="col"># Abonné</th>
				<th scope="col">Nom</th>
				<th scope="col">Prénom</th>
				<th scope="col">Email</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				while (rs.next()) {
			%>
			<tr>
				<th scope="row"><%=rs.getInt("IdA")%></th>
				<td><%=rs.getString("nom")%></td>
				<td><%=rs.getString("prenom")%></td>

				<td><%=rs.getString("email")%></td>



				<!-- avec ce bouton j'envoie dans l'entete l'IdV + la description  -->
				<!-- plus tous les paramettres de la vulnerabilité. de cette façon
		on peux modifier les valeurs -->
				<td><a class="btn btn-primary"
					href="modifAbo.jsp?IdA=<%=rs.getInt("IdA")%>
						&nom=<%=rs.getString("nom")%>
						&prenom=<%=rs.getString("prenom")%>
						&email=<%=rs.getString("email")%>
						">Modifier
				</a> <a class="btn btn-danger"
					href="ServletAbonne?IdA=<%=rs.getInt("IdA")%>">Supprimer</a></td>

			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	<%@ include file="WEB-INF/include/footer.jsp"%>
</body>
</html>