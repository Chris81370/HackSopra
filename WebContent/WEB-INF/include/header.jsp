<header>
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
		crossorigin="anonymous">
	<link rel="stylesheet" href="style.css" />

	<h1>H@ck Sopra</h1>
	<div class="modal fade" id="modalAbonne" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form action="ServletAbonne" method="post">
			<div class="modal-dialog" role="document">
				<div class="modal-content">

					<div class="modal-header text-center">
						<h4 class="modal-title w-100 font-weight-bold">S'abonner</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body mx-3">
						<div class="md-form mb-5">
							<i class="fas fa-user prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="orangeForm-name">Nom:<input
								type="text" class="form-control" name="nom" required>
						</div>
						<div class="md-form mb-5">
							<i class="fas fa-user prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="orangeForm-name">Prenom:<input
								type="text" class="form-control" name="prenom" required>
						</div>
						<div class="md-form mb-5">
							<i class="fas fa-envelope prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="defaultForm-email">Email:<input
								type="email" class="form-control" name="email" required>
								<input type="hidden" name="IdA" value="0">
						</div>
					</div>

					<div class="modal-footer d-flex justify-content-center">
						<input type="submit" class="btn btn-default" value="Enregistrer">
						<input type="reset" class="btn btn-default" value="Reset">

					</div>

				</div>
			</div>
		</form>
	</div>
	<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form action="ServletAdmin" method="post">
			<div class="modal-dialog" role="document">
				<div class="modal-content">

					<div class="modal-header text-center">
						<h4 class="modal-title w-100 font-weight-bold">Connexion</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body mx-3">
						<div class="md-form mb-5">
							<i class="fas fa-user prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="orangeForm-name">Votre
								identifiant</label> <input type="text" name="identifiant"
								class="form-control" required>
						</div>
						<div class="md-form mb-4">
							<i class="fas fa-lock prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="defaultForm-pass">Votre
								mot de passe</label> <input type="password" name="mdp"
								class="form-control" required>
						</div>
					</div>

					<div class="modal-footer d-flex justify-content-center">
						<input type="submit" class="btn btn-default" value="Login"></input>
					</div>

				</div>
			</div>
			<%
				if (session.getAttribute("erreur") != null) {
			%>
			<span class="badge badge-danger">Compte non reconnu</span>
			<%
				}
			%>
		</form>
	</div>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "><a class="nav-link" href="index.jsp">Accueil
						<span class="sr-only"></span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="actualite.jsp">Actualités</a>
				</li>
				<div class="nav-item">
					<a href="" class="nav-link" data-toggle="modal"
						data-target="#modalAbonne">S'abonner</a>
				</div>
				<div class="nav-item">
					<a href="" class="nav-link" data-toggle="modal"
						data-target="#modalLoginForm">Espace Administrateur</a>
				</div>
			</ul>
		</div>
	</nav>
	<!-- jQuery and JS bundle w/ Popper.js -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</header>