package Katalon.pages;

import Katalon.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MakeAppointment {

    public MakeAppointment(){
        super();
    }

    public void facility(){
        WebElement facilityDropdown = DriverManagerTL.getDriver().findElement(By.xpath("//select[@id='combo_facility']"));
        Select select;
        select = new Select(facilityDropdown);
        select.selectByValue("Seoul CURA Healthcare Center");

    }

    public void visitDate(){
        WebElement dateField = DriverManagerTL.getDriver().findElement(By.xpath("//input[@id='txt_visit_date']"));
        dateField.clear();
        dateField.sendKeys("14/07/2025");
    }

    By applyHospital = By.id("chk_hospotal_readmission");
    By healthCare = By.id("radio_program_medicare");
    By comment = By.id("txt_comment");
    By bookAppointment = By.id("btn-book-appointment");

    public void enterComment(){
        WebElement commentBox = DriverManagerTL.getDriver().findElement(comment);
        commentBox.clear();
        commentBox.sendKeys("This is the Test Comment!!!");
    }

    public MakeAppointment BookToAppointment(){
        facility();
        DriverManagerTL.getDriver().findElement(applyHospital).click();
        DriverManagerTL.getDriver().findElement(healthCare).click();
        visitDate();
        enterComment();
        DriverManagerTL.getDriver().findElement(bookAppointment).click();
        return this;
    }


}
