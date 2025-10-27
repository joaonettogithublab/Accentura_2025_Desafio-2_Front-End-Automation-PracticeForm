package base;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        BasePage.initialize();
    }

    @After
    public void afterScenario(Scenario scenario) {
        BasePage.tearDown();
    }
}