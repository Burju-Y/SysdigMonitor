package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CommonMethods;
import utilities.ConfigFileReader;
import utilities.Constants;
import utilities.Driver;

public class Hooks {

    @Before
    public void start(Scenario scenario) {
        ConfigFileReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        System.out.println("Setting up browser...");
        System.out.println("Starting scenario : " + scenario.getName());
    }

    @After
    public void end(Scenario scenario) {
        System.out.println("Ending scenario : " + scenario.getName());

        if (scenario.isFailed()) {

            byte[] screenshot = CommonMethods.takeScreenShot("/failed/" + scenario.getName());
            scenario.attach(screenshot, "image/png", "failedScenario");
        }
        scenario.getStatus();
        Driver.tearDown();
    }
}
