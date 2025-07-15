package Katalon.pages;

import Katalon.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage(){
        super();
    }

    By makeAppointment = By.id("btn-make-appointment");

    public LoginPage clickMakeAppointment(){
        clickElement(makeAppointment);
        return new LoginPage();
    }
}
