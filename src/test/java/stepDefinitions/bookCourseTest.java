package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import utilities.Utilities;
import java.util.List;

import static org.junit.Assert.*;

public class bookCourseTest extends Utilities {

    private static final String pricingUrl = "https://cloudacademy.com/pricing/";
    boolean courseFound = false;

    @Given("^I navigate to Cloud Academy to search for (.+) course$")
    public void navigateToWebsite(String courseName){
        libraryPage.getLandingPage();
        libraryPage.searchCourse(courseName);

        //Validate search results
        List<WebElement> links = libraryPage.getLinks();
        courseFound = false;
        if (!links.isEmpty()) {
            for (WebElement link : links) {
                if (link.getText().contains(courseName) || link.getText().contains("Google")) {
                    courseFound = true;
                    break; // when the first course is found, stop checking
                }
                assertTrue(courseName + "course was found", courseFound);
            }
        } else {
            fail("No links about '" +courseName+ "' were found.");
        }
    }

    @When("I go to the pricing plans to select one")
    public void validatePricing(){
        libraryPage.goToPricing();

        //Validate the page is the Pricing Page
        pricingPage.searchForTitle();
        validateURL(pricingPage.getCurrentUrl(), pricingUrl);

        //Validate the pricing plans are been shown
        List<WebElement> planBoxs = pricingPage.getPricingPlans();
        assertFalse("Found " + planBoxs.size() + " Pricing Plans.", planBoxs.isEmpty());

        //Select Small Team Plan
        pricingPage.clickOnStartNow();
    }

    @Then("I should see the Sign Up Form")
    public void validateForm(){
        assertTrue(signUpPage.areFieldsDisplayed(
                "firstname",
                "lastname",
                "email",
                "password"
        ));
    }

    public void validateURL(String currentUrl, String expectedUrl) {
        System.out.println("Current URL: " + currentUrl);
        assertEquals (currentUrl, expectedUrl);
    }
}