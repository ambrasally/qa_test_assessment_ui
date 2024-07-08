package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pageObjects.BaseTestSuite;

@RunWith(Cucumber.class)
@CucumberOptions(
        features   = "./src/test/java/features",
        glue       = "stepDefinitions",
        tags       = "@smoke",
        plugin     = {"pretty", "html:src/test/resources/reports/cucumber-report.html"},
        monochrome = true
)

public class TestRunner{
    @AfterClass
    public static void tearDownClass(){
        BaseTestSuite.tearDown();
    }
}
