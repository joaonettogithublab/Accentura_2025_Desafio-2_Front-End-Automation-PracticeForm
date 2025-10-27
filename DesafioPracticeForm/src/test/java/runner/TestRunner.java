package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "base"},
        // Configuração de relatório HTML básico e JSON
        plugin = {"pretty", "html:target/cucumber-reports/html", "json:target/cucumber.json"},
        tags = {"@Scenario01"},
        monochrome = true
)
public class TestRunner {
    //
}
