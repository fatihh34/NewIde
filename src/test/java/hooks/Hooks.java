package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
    String browserName = "chrome";
    DesiredCapabilities capabilities;
    ChromeOptions chromeOptions;
    public static WebDriver driver;
    public static Actions actions;
    public Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUpScenarios(){
        try{
            if (StringUtils.isEmpty(System.getProperty("key"))) {

                switch (ConfigReader.getProperty("browser")) {
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().clearDriverCache().setup();

                        //options.addArguments("--remote-allow-origins=*");
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;

                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                        break;
                }
                driver.manage().window().maximize();

            }else {
                //WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                capabilities = DesiredCapabilities.chrome();
                options.setExperimentalOption("w3c", false);
                options.addArguments("disable-translate");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-fullscreen");
                Map<String, Object> prefs = new HashMap<>();
                options.setExperimentalOption("prefs", prefs);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability("key", System.getProperty("key"));
                browserName = System.getenv("browser");
                driver = new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities);
                actions = new Actions(driver);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
    @After
    public void tearDownScenarios(Scenario scenario) throws InterruptedException {
        if (driver != null) {
            // driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

