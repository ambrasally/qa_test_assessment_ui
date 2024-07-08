package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PricingPage extends BaseTestSuite{
    By title = By.xpath("//h1[contains(text(), 'Pricing and plans')]");
    By planBox = By.className("dbVyeJ");
    By startNowButton = By.xpath("//span[contains(text(),'Start Now')]");

    public PricingPage() {
        super(driver);
    }

    public void searchForTitle(){
        searchElement(title);
    }

    public String getCurrentUrl(){
        return getCurrentURL();
    }

    public List<WebElement> getPricingPlans(){
        return getListOfElements(planBox);
    }

    public void clickOnStartNow(){
        clickOnElement(startNowButton);
    }
}
