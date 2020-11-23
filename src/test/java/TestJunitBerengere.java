import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.LinkedList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import pack.*;

class TestJunitBerengere {
	// Déclaration attributs abonne
	Abonne abonneTest = new Abonne();
	Abonne Abonne;
	String nom = "Toto";
	String prenom = "Lulu";
	String email = "test-@gmail.com";
	String IdA = "1";
	LinkedList<Abonne> listeAbonnes = new LinkedList<Abonne>();

	@BeforeEach
	public void init() {
		Abonne = new Abonne();

	}

	/*
	 * @InjectMocks private Connexion conn ;
	 * 
	 * @Mock private Connexion mockConn;
	 * 
	 * @Mock private Statement mockStatement;
	 * 
	 * @BeforeEach public void setUp() { MockitoAnnotations.initMocks(this); }
	 * 
	 * @Test void test() throws Exception {
	 * Mockito.when(mockConn.createStatement()).thenReturn(mockStatement);
	 * Mockito.when(mockConn.createStatement().executeUpdate(Mockito.anyString()).
	 * thenReturn(1)); int value=Connexion. int value=conn.executeQuery("");
	 * assertEquals(1, value); }
	 * 
	 */
	@Test
    public void CRUDAbonnes() throws Exception {

                try {

	//creation abonne
	Abonne abonne1;
	abonne1 = new Abonne(nom,prenom, email);
    abonne1.create();
    assertEquals(nom, abonneTest.display().getLast().getNom());
    assertEquals(prenom, abonneTest.display().getLast().getPrenom());
    assertEquals(email, abonneTest.display().getLast().getEmail());
   // update
    abonne1.setIdA(abonneTest.display().getLast().getIdA());
   abonne1.setNom("testUpdateNom");
   abonne1.setPrenom("testUpdatePrenom");
   abonne1.setEmail("testUpdateEmail");
   abonne1.update();
   //delete
   assertEquals("testUpdateNom", abonneTest.display().getLast().getNom());
   assertEquals("testUpdatePrenom", abonneTest.display().getLast().getPrenom());
   assertEquals("testUpdateEmail", abonneTest.display().getLast().getEmail());
  
   abonne1.delete();

   assertTrue(!abonneTest.display().contains(abonne1));
                } finally {

                }
    }



	@Test
	protected void setUpAbonne() throws Exception {
		Abonne a = new Abonne();
		Abonne am = new Abonne("email");
		Abonne = new Abonne("Toto", "Lulu", "test-@gmail.com");
		assertNotNull("L'instance n'est pas créée", Abonne);
		assertEquals("Le nom est incorrect", "Toto", Abonne.getNom());
		assertEquals("Le prenom est incorrect", "Lulu", Abonne.getPrenom());
		assertEquals("L email est incorrect", "test-@gmail.com", Abonne.getEmail());
		assertEquals("listeAbonnes", listeAbonnes.display().getLast().getListeAbonnes());
	}

	@Test
	// LOIC
	protected void setUpAdmin() throws Exception {

		Admin Admin = new Admin("admin", "admin");
		assertNotNull("L'instance n'est pas créée", Admin);
		assertEquals("Le nom est incorrect", "admin", Admin.getIdentifiant());
		assertEquals("Le prenom est incorrect", "admin", Admin.getMdp());

	}

	@Test
	// ANGELO
	protected void setUpVulnerabilite() throws Exception {

		Vulnerabilite Vulnerabilite = new Vulnerabilite(5, "LOCKY", "le rançongiciel le plus répandu",
				"Le virus LOCKY cible directement des fichiers port...", "powerpoint, excel, word");
		assertNotNull("L'instance n'est pas créée", Vulnerabilite);
		assertEquals("Le titre est incorrect", "LOCKY", Vulnerabilite.getTitre());
		assertEquals("La synthèse est incorrecte", "le rançongiciel le plus répandu", Vulnerabilite.getSynthese());
		assertEquals("La description est incorrecte", "Le virus LOCKY cible directement des fichiers port...",
				Vulnerabilite.getDescription());
		assertEquals("Le logiciel est incorrect", "powerpoint, excel, word", Vulnerabilite.getLogiciels());
		assertEquals("La gravité est incorrecte", 5, Vulnerabilite.getGravite());
	}

	@Test
	// CHRISTOPHE
	protected void setUpContreMesure() throws Exception {

		ContreMesure ContreMesure = new ContreMesure(2, "Mag log", "mettre à jour le fichier log", "www.google.com");
		assertNotNull("L'instance n'est pas créée", ContreMesure);
		assertEquals("Le titre est incorrect", "Mag log", ContreMesure.getTitre());
		assertEquals("La description est incorrecte", "mettre à jour le fichier log", ContreMesure.getDescription());
		assertEquals("La source est incorrecte", "www.google.com", ContreMesure.getSources());
		assertEquals("L id Vulnerabilite est incorrecte", 2, ContreMesure.getIdV());
	}

	

	@Test
	public void testAbonne() {
		assertNotNull("L'instance n'est pas créée", Abonne);
	}

	@Test
	public void ListeAbonnes() {
		Abonne.setListeAbonnes(listeAbonnes);
		assertEquals("La liste est incorrecte", "listeAbonnes", Abonne.getListeAbonnes());
	}

	@Test
	public void testSetNom() {
		Abonne.setNom("Test");
		assertEquals("Le nom est incorrect", "Test", Abonne.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertEquals("Le prenom est incorrect", "Lulu", Abonne.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		Abonne.setPrenom("test");
		assertEquals("Le prenom est incorrect", "test", Abonne.getPrenom());
	}

	@Test
	public void testSetEmail() {
		Abonne.setEmail("test-@gmail.com");
		assertEquals("L email est incorrect", "test-@gmail.com", Abonne.getEmail());
	}
	/*
	 * @Test public void testSetNom1() { Abonne.setNom("Test");
	 * assertEquals("Le nom est incorrect", "Test", Abonne.getNom()); try {
	 * Abonne.setNom(null);
	 * fail("IllegalArgumentException non levée avec la propriété nom à null"); }
	 * catch (IllegalArgumentException iae) { // ignorer l'exception puisque le test
	 * est OK (l'exception est levée) } }
	 */

	@Test
	public void testSetNom2() {
		Abonne.setNom("Test");
		assertTrue(Abonne.getNom() == "Test");
	}

	@Test
	public void testSetPrenom2() {
		Abonne.setPrenom("test");
		assertTrue(Abonne.getPrenom() == "test");
	}

	@Test
	public void testSetEmail2() {
		Abonne.setEmail("132@gmail.com");
		assertTrue(Abonne.getEmail() == "132@gmail.com");
	}

	
}