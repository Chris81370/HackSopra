
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/resources", plugin = "html:out.html", monochrome = true)
@RunWith(Cucumber.class)
public class RunCucumberTest {

}
