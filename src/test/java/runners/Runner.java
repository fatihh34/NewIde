package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//raporlarin daha okunakli olmasi icin
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failed_scenario.txt",
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:test-output/"
        },
        monochrome = true,//raporlarin konsolda okunakli sekilde cikmasi icin
        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},   //stepdefinitions path
        tags = "@go_the_website",


        dryRun = false

)
public class Runner {

}

//Bu sinif Test Cseleri run etmek icin
//Ve konfigurasyonlar icin kullanilir
//Runners class, feature file lar ile step definition'i birbirine baglar



