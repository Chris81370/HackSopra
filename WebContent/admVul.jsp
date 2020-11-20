<%@page import="pack.ContreMesure"%>
<%@page import="com.mysql.jdbc.ResultSet"%>
<%@page import="pack.Vulnerabilite"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admVul</title>
<%
	Vulnerabilite v = new Vulnerabilite();

ResultSet rs = v.read();
ContreMesure cm = new ContreMesure();
ResultSet rsc = cm.read();
%>
</head>
<header>
	<h1>Liste des vulnérabilités</h1>
</header>
<%@ include file="WEB-INF/include/admNavBar.jsp"%>
<body>
	<a href="CreationVul.jsp" class="btn btn-success">Ajouter
		vulnerabilité</a>
	<!-- Modal -->
	<div align="center"></div>
	<form action="ServletContreMesure" method="get">
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
						<form action="ServletContreMesure" method="post">
							<table class="table table-borderless">

								<tr>

									<td># Vulnerabillite</td>
									<td><input type="number" name="IdV"
										value="<%=session.getAttribute("IdV")%>"></td>
								</tr>
								<br>
								<tr>
									<td>Titre</td>
									<td><input type="text" class="form-control" name="titre"
										required></td>
								</tr>
								<br>
								<tr>
									<td>Description</td>
									<td><input type="text" class="form-control"
										name="description" required></td>
								</tr>
								<br>
								<tr>
									<td>Sources</td>
									<td><input type="text" class="form-control" name="sources"></td>
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

	</table>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Vulnerabilité</th>
				<th scope="col">Synthese</th>
				<th scope="col">Gravité</th>
				<th scope="col">Desciption</th>
				<th scope="col">Logiciels affectés</th>
				<!--  <th scope="col">Contremesures</th>-->
				<!--	<th scope="col">Sources</th>-->
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				while (rs.next()) {
			%>
			<tr>
				<th scope="row"><%=rs.getInt("IdV")%></th>
				<td><%=rs.getString("titre")%></td>
				<td><%=rs.getString("synthese")%></td>
				<td><%=rs.getInt("gravite")%></td>
				<td><%=rs.getString("description")%></td>
				<td><%=rs.getString("logiciels")%></td>


				<!-- avec ce bouton j'envoie dans l'entete l'IdV + la description  -->
				<!-- plus tous les paramettres de la vulnerabilité. de cette façon
		on peux modifier les valeurs -->
				<td><a class="btn btn-primary"
					href="modifVul.jsp?IdV=<%=rs.getInt("IdV")%>
						&titre=<%=rs.getString("titre")%>
						&description=<%=rs.getString("description")%>
						&synthese=<%=rs.getString("synthese")%>
						&gravite=<%=rs.getInt("gravite")%>
						&logiciels=<%=rs.getString("logiciels")%>
						">Modifier
				</a> <a class="btn btn-danger"
					href="ServletVulnerabilite?IdV=<%=rs.getInt("IdV")%>">Supprimer</a><a
					class="btn btn-primary"
					href="CreationContreMesure.jsp?IdV=<%=rs.getInt("IdV")%>
						">Ajout
						Contre-Mesure </a> <%--<a class="btn btn-primary"
					href="modifContreMesure.jsp?IdC=<%=rsc.getInt("IdC")%>
						">Modifier
						Contre-Mesure </a> --%></td>

			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	<br>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col"># ContreMesure</th>
				<th scope="col"># Vulnerabilité</th>
				<th scope="col">Titre</th>
				<th scope="col">Desciption</th>
				<th scope="col">Sources</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				while (rsc.next()) {
			%>
			<tr>
				<th scope="row"><%=rsc.getInt("IdC")%></th>
				<th scope="row"><%=rsc.getInt("IdV")%></th>
				<td><%=rsc.getString("titre")%></td>
				<td><%=rsc.getString("description")%></td>
				<td><%=rsc.getString("sources")%></td>


				<!-- avec ce bouton j'envoie dans l'entete l'IdV + la description  -->
				<!-- plus tous les paramettres de la vulnerabilité. de cette façon
		on peux modifier les valeurs -->
				<td><a class="btn btn-primary"
					href="modifContreMesure.jsp?IdC=<%=rsc.getInt("IdC")%>
					&IdV=<%=rsc.getInt("IdV")%>
						&titre=<%=rsc.getString("titre")%>
						&description=<%=rsc.getString("description")%>						
						&sources=<%=rsc.getString("sources")%>
						">Modifier
				</a> <a class="btn btn-danger"
					href="ServletContreMesure?IdC=<%=rsc.getInt("IdC")%>">Supprimer</a>
					<%--<a class="btn btn-primary"
					href="modifContreMesure.jsp?IdC=<%=rsc.getInt("IdC")%>
						">Modifier
						Contre-Mesure </a> --%></td>

			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	<%@ include file="WEB-INF/include/footer.jsp"%>
</body>
</html>