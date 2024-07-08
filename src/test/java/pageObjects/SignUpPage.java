package pageObjects;

import org.openqa.selenium.By;

public class SignUpPage extends BaseTestSuite{

    By firstName = By.cssSelector("input[name=first_name]");
    By lastName = By.cssSelector("input[name=last_name]");
    By email = By.cssSelector("input[name=email]");
    By password = By.cssSelector("input[name=password]");

    public SignUpPage(){
        super(driver);
    }

    public boolean areFieldsDisplayed(String... fields) throws IllegalStateException {
        for (String field : fields) {
            switch (field) {
                case "firstname" -> isElementDisplayed(firstName);
                case "lastname" -> isElementDisplayed(lastName);
                case "email" -> isElementDisplayed(email);
                case "password" -> isElementDisplayed(password);
                default -> throw new IllegalStateException("Unexpected value: " + field);
            };
        }
        return true;
    }
}

