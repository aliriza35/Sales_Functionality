package cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "junit:target/junit/junit-report.xml",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "cydeo/step_definitions",
        dryRun = false,
        stepNotifications = true,
        tags = "@BRT-787"
)

public class CukesRunner {
}
