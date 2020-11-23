
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.xerces.impl.dtd.models.CMAny;
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
	// Déclaration attributs ContreMesure
	private int IdV1, IdC1;
	private String titre, description, sources, IdC, IdV;

	@BeforeEach
	void init() {
		ContreMesure cm = new ContreMesure();
		ContreMesure c1 = new ContreMesure("description", "sources");
		ContreMesure c2 = new ContreMesure(1, "titre", "description", "sources");
	}

	@Test
	void initialistationVariables() {

//		Abonne a = new Abonne();
//		Abonne a1 = new Abonne("nom", "prenom", "email");
//		Abonne am = new Abonne("email");
//		ContreMesure c = new ContreMesure();
//		ContreMesure c1 = new ContreMesure("description", "sources");
//		ContreMesure c2 = new ContreMesure(1, "titre", "description", "sources");

//		Vulnerabilite v = new Vulnerabilite();
//		Vulnerabilite v1 = new Vulnerabilite(1, "titre", "synthese", "description", "logiciels");
//		Admin ad = new Admin();
//		Admin ad1 = new Admin("ter", "ted");
//		Admin ad2 = new Admin("1", "identifiant", "mdp");
//
//		ServletAbonne sa = new ServletAbonne();
//		ServletAdmin sad = new ServletAdmin();
//		ServletContreMesure scm = new ServletContreMesure();
//		ServletDeconnexion sd = new ServletDeconnexion();
//		ServletVulnerabilite sv = new ServletVulnerabilite();
	}

	@Test
	public void testGetIdV() {
		ContreMesure cIdV = new ContreMesure(1, "titre", "description", "sources");
		assertEquals("L'ID est incorrect", 1, cIdV.getIdV());
	}

	@Test
	public void testSetIdV(int idV) {
		ContreMesure c2 = new ContreMesure(1, "titre", "description", "sources");
		c2.setIdV(10);
		assertEquals("Le IdC est incorrect", idV, c2.getIdV());
	}

	@Test
	protected void setUpAbonne() throws Exception {
		ContreMesure cm1 = new ContreMesure();
		ContreMesure cm2 = new ContreMesure("description", "sources");
		ContreMesure cm3 = new ContreMesure(1, "titre", "description", "sources");
		assertNotNull("L'instance n'est pas créée", cm1);
		assertEquals("La description est incorrect", "description", cm2.getDescription());
		assertEquals("La source est incorrect", "sources", cm2.getSources());
		assertEquals(1, IdV1, cm3.getIdV());
		assertEquals("Le titre est incorrect", "titre", cm3.getTitre());
		assertEquals("La description est incorrect", "description", cm3.getDescription());
		assertEquals("La source est incorrect", "sources", cm3.getSources());

		// assertEquals("Le prenom est incorrect", "Lulu", Abonne.getPrenom());
		// assertEquals("L email est incorrect", "test-@gmail.com", Abonne.getEmail());
	}

	@Test
	public void testGetIdC() {
		ContreMesure cIdC = new ContreMesure(1, "titre", "description", "sources");
		assertEquals("L'ID est incorrect", 1, cIdC.getIdC());
	}

	@Test
	public void testSetIdC(int idC) {
		ContreMesure cm = new ContreMesure();
		cm.setIdC(10);
		assertEquals("Le IdC est incorrect", idC, cm.getIdC());
	}

	@Test
	public void testSetTitre(String titre) {
		if (titre == null) {
			throw new IllegalArgumentException("la propriété titre ne peut pas être null");
		}
		this.titre = titre;
	}

	@Test
	public void testSetDescription(String description) {
		ContreMesure cm2 = new ContreMesure("description", "sources");
		cm2.setDescription("description");
		assertEquals("La description est incorrect", description, cm2.getDescription());
	}

	@Test
	public void testSetSources(String source) {
		ContreMesure cm2 = new ContreMesure("description", "sources");
		cm2.setSources("source");
		assertEquals("La source est incorrect", source, cm2.getSources());
	}
}
