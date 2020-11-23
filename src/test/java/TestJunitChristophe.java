
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.xerces.impl.dtd.models.CMAny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mysql.jdbc.Connection;

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
	private int IdV, IdC;
	private String titre, description, sources, IdC1, IdV1;

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
	public void testSetIdV() {
		ContreMesure c2 = new ContreMesure();
		c2.setIdV(10);
		assertEquals(10, c2.getIdV());
	}

	@Test
	protected void setUpAbonne() throws Exception {
		ContreMesure cm1 = new ContreMesure();
		ContreMesure cm2 = new ContreMesure("description", "sources");
		ContreMesure cm3 = new ContreMesure(1, "titre", "description", "sources");
		assertNotNull("L'instance n'est pas créée", cm1);
		assertEquals("La description est incorrect", "description", cm2.getDescription());
		assertEquals("La source est incorrect", "sources", cm2.getSources());
		assertEquals(1, IdV, cm3.getIdV());
		assertEquals("Le titre est incorrect", "titre", cm3.getTitre());
		assertEquals("La description est incorrect", "description", cm3.getDescription());
		assertEquals("La source est incorrect", "sources", cm3.getSources());

		// assertEquals("Le prenom est incorrect", "Lulu", Abonne.getPrenom());
		// assertEquals("L email est incorrect", "test-@gmail.com", Abonne.getEmail());
	}

	@Test
	public void testGetIdC() {
		ContreMesure cIdC = new ContreMesure();
		cIdC.setIdC(1);
		assertEquals(1, cIdC.getIdC());
	}

	@Test
	public void testSetIdC() {
		ContreMesure cm = new ContreMesure();
		cm.setIdC(10);
		assertEquals(10, cm.getIdC());
	}

	@Test
	public void testSetTitre() {
		ContreMesure cm = new ContreMesure();
		cm.setTitre("nouveau");
		assertEquals("nouveau", cm.getTitre());

	}

	@Test
	public void testSetTitreNull() {
		ContreMesure cm = new ContreMesure();
		cm.setTitre(null);
		assertNull(titre);

	}

	@Test
	public void testSetDescription() {
		ContreMesure cm2 = new ContreMesure("description", "sources");
		cm2.setDescription("description");
		assertEquals("description", cm2.getDescription());
	}

	@Test
	public void testSetSources() {
		ContreMesure cm2 = new ContreMesure("description", "sources");
		cm2.setSources("source");
		assertEquals("source", cm2.getSources());
	}

	// Attributs des Contremesures

	ContreMesure contremesureTest = new ContreMesure();

	// Test CRUD Contremesures

	@Test

	public void CRUDContremesures() throws Exception {

		try {

			// Create ContreMesure

			// contremesureTest.setIdV(idVulnerabilite);
			ContreMesure cm1;
			IdV = 18;
			IdC = 15;
			titre = "titre";
			description = "description";
			sources = "sources";
			cm1 = new ContreMesure(IdV, titre, description, sources);
			System.out.println(cm1.getDescription());
			cm1.create();
			assertEquals(IdV1, contremesureTest.display().getLast().getIdV());
			assertEquals(titre, contremesureTest.display().getLast().getTitre());
			assertEquals(description, contremesureTest.display().getLast().getDescription());
			assertEquals(sources, contremesureTest.display().getLast().getSources());
			// Update ContreMesure

			cm1.setIdC(contremesureTest.display().getLast().getIdC());
			cm1.setTitre("testUpdateNom");
			cm1.setDescription("testUpdateDesc");

			cm1.update();
			assertEquals("testUpdateNom", contremesureTest.display().getLast().getTitre());
			assertEquals("testUpdateDesc", contremesureTest.display().getLast().getDescription());

			cm1.delete();
			assertTrue(!contremesureTest.display().contains(cm1));
		} finally {

		}

	}

}
