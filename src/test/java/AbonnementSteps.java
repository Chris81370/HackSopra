
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pack.Abonne;

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
}
