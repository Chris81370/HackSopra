
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.cucumber.java.Before;
import pack.Abonne;
import pack.Admin;
import pack.ContreMesure;
import pack.ServletAbonne;
import pack.ServletAdmin;
import pack.ServletContreMesure;
import pack.ServletDeconnexion;
import pack.ServletVulnerabilite;
import pack.Vulnerabilite;

class TestJunitChristophe {

	@Test
	void initialistationVariables() {

		Abonne a = new Abonne();
		Abonne a1 = new Abonne("nom", "prenom", "email");
		Abonne am = new Abonne("email");
		ContreMesure c = new ContreMesure();
		ContreMesure c1 = new ContreMesure("description", "sources");
		ContreMesure c2 = new ContreMesure(1, "titre", "description", "sources");

		Vulnerabilite v = new Vulnerabilite();
		Vulnerabilite v1 = new Vulnerabilite(1, "titre", "synthese", "description", "logiciels");
		Admin ad = new Admin();
		Admin ad1 = new Admin("ter", "ted");
		Admin ad2 = new Admin("1", "identifiant", "mdp");

		ServletAbonne sa = new ServletAbonne();
		ServletAdmin sad = new ServletAdmin();
		ServletContreMesure scm = new ServletContreMesure();
		ServletDeconnexion sd = new ServletDeconnexion();
		ServletVulnerabilite sv = new ServletVulnerabilite();
	}

}
