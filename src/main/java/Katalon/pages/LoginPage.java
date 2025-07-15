package Katalon.pages;

import Katalon.base.BasePage;
import Katalon.driver.DriverManagerTL;
import Katalon.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }


    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By login = By.id("btn-login");
    By error_message = By.xpath("//p[@class='lead text-danger']");

    public LoginPage LoginToKatalon(boolean valid) throws Exception {
        if (valid) {
            enterInput(username, PropertyReader.readkey("username"));
        } else {
            enterInput(username, PropertyReader.readkey("invalid_username"));
        }
        enterInput(password, PropertyReader.readkey("password"));
        clickElement(login);
        return this;
    }

    public String error_message_text() {
        visibilityOfElementLocated(error_message);
        return DriverManagerTL.getDriver().findElement(error_message).getText();
    }


}
