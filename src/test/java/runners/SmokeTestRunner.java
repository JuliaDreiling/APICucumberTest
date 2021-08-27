package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:Reports/htmlReport.html",
                "json:Reports/jsonReport.json"},
        features="features/test.feature",
        glue="step_definitions",
        dryRun=false,
        tags="@SmokeTest",
        publish=true
)
public class SmokeTestRunner {

}