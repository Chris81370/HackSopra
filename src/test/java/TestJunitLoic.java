import static org.junit.Assert.*;
import org.junit.Test;
import pack.*;


public class TestJunitLoic {

	String identifiant;
	String mdp;
	String idAdm;
	Admin admin1;
	
	@Test
	public void setUpAdmin() throws Exception {
		Admin Admin = new Admin("admin", "admin");
		Admin Admin2 = new Admin("id1", "admin", "admin");
		assertNotNull("L'instance n'est pas créée", Admin);
		assertEquals("L'Identifiant est incorrect", "admin", Admin.getIdentifiant());
		assertEquals("Le mot de passe est incorrect", "admin", Admin.getMdp());
		assertNotNull("L'instance n'est pas créée", Admin2);
		assertEquals("L'ID est incorrect", "admin", Admin2.getIdentifiant());
		assertEquals("L'Identifiant est incorrect", "admin", Admin2.getIdentifiant());
		assertEquals("Le mot de passe est incorrect", "admin", Admin2.getMdp());
	}
	@Test
	public void tearDown() throws Exception {
	    admin1 = null;
	}
	@Test
	public void testAdmin() {
		admin1 = new Admin();
		assertNotNull("L'instance n'est pas créée", admin1);
	}
	@Test
	public void testGetIdAdm() {
		Admin admin1 = new Admin("id1","admin", "admin");
		assertEquals("L'IdAdm est incorrect", "id1", admin1.getIdAdm());
	}
	@Test
	public void testSetIdAdm() {
		Admin admin1 = new Admin("id1","admin", "admin");
		admin1.setIdAdm("id1");
		assertEquals("L'IdAdm est incorrect", "id1", admin1.getIdAdm());
	}
	@Test
	public void testGetIdentifiant() {
		Admin admin1 = new Admin("admin", "admin");
		assertEquals("L'identifiant est incorrect", "admin", admin1.getIdentifiant());
	}
	@Test
	public void testSetIdentifiant() {
		Admin admin1 = new Admin("admin", "admin");
		admin1.setIdentifiant("admin");
		assertEquals("L'identifiant est incorrect", "admin", admin1.getIdentifiant());
	}
	@Test
	public void testGetMdp() {
		Admin admin1 = new Admin("admin", "admin");
		assertEquals("Le mot de passe est incorrect", "admin", admin1.getMdp());
	}
	@Test
	public void testSetMdp() {
		Admin admin1 = new Admin("admin", "admin");
		admin1.setMdp("admin");
		assertEquals("Le mot de passe est incorrect", "admin", admin1.getMdp());
	}
	// Test CRUD Abonnes
	@Test
	public void CRUDAdmin() throws Exception {
		try {
			// Authentifier Abonne
			Admin admin1 = new Admin();
			admin1.authentifier();
			assertEquals(identifiant, admin1.getIdentifiant());
			assertEquals(mdp, admin1.getMdp());
		} 
		finally {
		}
	}
}



