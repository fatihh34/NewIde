package stepdefinitions;
import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Homepage;
import utilities.ConfigReader;

public class HomePageStepDefinitions {

    Homepage homepage= new Homepage();

    @When("user goes the page")
    public void userGoesThePage() {

        Hooks.getDriver().get(ConfigReader.getProperty("url"));



    }

    @Then("user search {string} in searchbox")
    public void userSearchInSearchbox(String arg0) {
        homepage.searchBox.sendKeys("ürün", Keys.ENTER);
    }

    @Then("user validate that there is no product")
    public void userValidateThatThereIsNoProduct() {
        Assert.assertTrue(homepage.searchResult.isDisplayed());

    }
}

