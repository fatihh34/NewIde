package stepdefinitions;
import hooks.Hooks;
import io.cucumber.java.en.When;
import utilities.ConfigReader;

public class HomePageStepDefinitions {
    @When("user goes the page")
    public void userGoesThePage() {

        Hooks.getDriver().get(ConfigReader.getProperty("url"));



    }
}

