package Katalon.base;

import Katalon.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected BasePage() {

    }

    protected void enterInput(By by, String key) {
        DriverManagerTL.getDriver().findElement(by).sendKeys(key);

    }

    protected WebElement getElement(By key) {
        return DriverManagerTL.getDriver().findElement(key);
    }

    protected void clickElement(By by) {
        DriverManagerTL.getDriver().findElement(by).click();
    }

    protected void visibilityOfElementLocated(By elementLocation) {
        new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected void presenceOfElementLocated(By elementLocation) {
        new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
}
