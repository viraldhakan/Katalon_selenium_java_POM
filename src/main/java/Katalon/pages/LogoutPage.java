package Katalon.pages;

import Katalon.driver.DriverManagerTL;
import org.openqa.selenium.By;

public class LogoutPage {

    public LogoutPage(){
        super();
    }

    By menu = By.id("menu-toggle");
    By logout = By.xpath("//a[text()='Logout']");

    public LogoutPage LogoutUser(){
        DriverManagerTL.getDriver().findElement(menu).click();
        DriverManagerTL.getDriver().findElement(logout).click();
        return this;
    }
}
