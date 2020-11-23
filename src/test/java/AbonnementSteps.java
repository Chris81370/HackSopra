
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pack.Abonne;
import pack.Vulnerabilite;

public class AbonnementSteps {

	@Given("lutilisateur cree son abonnement")
	public void lutilisateur_cree_son_abonnement() {
		Abonne a = new Abonne();

	}

	@When("lutilisateur rempli {string} , {string} et {string}")
	public void constructionAbonne(String nom, String prenom, String email) {
		Abonne a = new Abonne(nom, prenom, email);
		assertEquals("Yoyo", nom);
		assertEquals("tata", prenom);
		assertEquals("tatayoyo@gmail.com", email);
	}

	@Then("lutilisateur est ajoute")
	public void theBoardShouldLookLikeThis() {

		System.out.println("Abonne cree");
	}

	@Given("ladmin cree une vulnerabilite")
	public void ladmin_cree_une_vulnerabilite() {
		Vulnerabilite v = new Vulnerabilite();

	}

	@When("ladmin rempli {int}, {string}, {string}, {string}, {string}")
	public void constructionAbonne(Integer gravite, String titre, String synthese, String description,
			String logiciels) {
		Vulnerabilite v = new Vulnerabilite(gravite, titre, synthese, description, logiciels);
		assertEquals(1, gravite);
		assertEquals("titre", titre);
		assertEquals("synthese", synthese);
		assertEquals("description", description);
		assertEquals("logiciels", logiciels);
	}

	@Then("la vulnerabilite est ajoutee")
	public void test() {

		System.out.println("Vulnerabilite cree");
	}

}
