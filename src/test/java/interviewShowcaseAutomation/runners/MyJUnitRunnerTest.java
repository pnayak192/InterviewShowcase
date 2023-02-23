
package interviewShowcaseAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"interviewShowcaseAutomation"},
        features = "src/test/resources/features/createUser.feature",
        plugin = { "html:target/cucumber/cucumber.html" },
        tags = "@smoke, @Regression"
)
public class MyJUnitRunnerTest {
}

