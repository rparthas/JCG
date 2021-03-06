import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report", "rerun:target/rerun.txt"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@multiple"})
public class Launcher {

}
