
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BoardSteps {
	private List<List<String>> board;

	@Given("^a board like this:$")
	public void aBoardLikeThis(DataTable table) throws Throwable {
		this.board = table.asLists();
	}

	@When("^player x plays in row (\\d+), column (\\d+)$")
	public void playerXPlaysInRowColumn(int arg1, int arg2) throws Throwable {
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(i).size(); j++) {
				if (board.get(i).get(j) != null)
					System.out.print("|" + board.get(i).get(j));
				else
					System.out.print("|  ");
			}
			System.out.println("|");
		}
	}

	@Then("^the board should look like this:$")
	public void theBoardShouldLookLikeThis(DataTable arg1) throws Throwable {
		this.board = arg1.asLists();
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(i).size(); j++) {
				if (board.get(i).get(j) != null)
					System.out.print("|" + board.get(i).get(j));
				else
					System.out.print("|  ");
			}
			System.out.println("|");
		}
	}
}