package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseTestSuite {
    protected static WebDriver driver;
    private static WebDriverWait wdWait;
    private static String browser = "Firefox";

    static {
        initializeDriver();
    }

    public static void initializeDriver() {
        if (browser.equals("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();

        } else if (browser.equals("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public BaseTestSuite(WebDriver driver){
        BaseTestSuite.driver = driver;
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void tearDown(){
        driver.quit();
    }

    public WebElement searchElement(By locator){
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void getLandingPage(String url){
        driver.get(url);
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void clickOnElement(By locator){
        searchElement(locator).click();
    }

    public void typeOnElement(By locator, String text) {
        searchElement(locator).sendKeys(text);
    }

    public List<WebElement> getListOfElements(By locator){
        return driver.findElements(locator);
    }

    public boolean isElementDisplayed(By locator){
        return searchElement(locator).isDisplayed();
    }
}
