package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LibraryPage extends BaseTestSuite{

    String baseUrl = "https://cloudacademy.com/library";
    By searchInput = By.cssSelector("input[placeholder='Search in our library...']");
    By contentCards = By.className("eZqxSR");
    By pricingButton = By.xpath("//span[contains(text(),'Pricing & Plans')]");

    public LibraryPage() {
        super(driver);
    }

    public void getLandingPage(){
        getLandingPage(baseUrl);
    }

    public void searchCourse(String courseName){

        String dynamicLocator = "//span[contains(text(),'" +courseName.toLowerCase()+ "')]";
        By courseElement = By.xpath(dynamicLocator);
        typeOnElement(searchInput, courseName);
        clickOnElement(courseElement);
    }

    public List<WebElement> getLinks(){
        searchElement(contentCards);
        return getListOfElements(contentCards);

    }

    public void goToPricing(){
        clickOnElement(pricingButton);
    }
}
