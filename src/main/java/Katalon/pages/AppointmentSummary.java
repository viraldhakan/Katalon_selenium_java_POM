package Katalon.pages;

import Katalon.base.BasePage;
import org.openqa.selenium.By;

public class AppointmentSummary extends BasePage {

    public AppointmentSummary() {
        super();
    }

    By appConfirm = By.xpath("//h2[text()='Appointment Confirmation']");
    By facility = By.xpath("//p[@id='facility']");
    By hospitalReadmission = By.xpath("//p[@id='hospital_readmission']");
    By healthProgram = By.xpath("//p[@id='program']");
    By visitDate = By.xpath("//p[@id='visit_date']");
    By comment = By.xpath("//p[@id='comment']");

    public String LoggedInInformation() {
        presenceOfElementLocated(appConfirm);
        return getElement(appConfirm).getText();
    }

    public String getFacility() {
        presenceOfElementLocated(facility);
        return getElement(facility).getText();
    }


    public String getHospitalRead() {
        presenceOfElementLocated(hospitalReadmission);
        return getElement(hospitalReadmission).getText();
    }

    public String getHealthProgram() {
        presenceOfElementLocated(healthProgram);
        return getElement(healthProgram).getText();
    }

    public String getVisitDate() {
        presenceOfElementLocated(visitDate);
        return getElement(visitDate).getText();
    }

    public String getComment() {
        presenceOfElementLocated(comment);
        return getElement(comment).getText();
    }


}
