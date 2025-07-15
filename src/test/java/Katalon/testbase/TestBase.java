package Katalon.testbase;

import Katalon.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.io.ByteArrayInputStream;

public class TestBase {


    @BeforeMethod
    protected void init(){
        DriverManagerTL.init();
    }

    @AfterMethod
    protected  void down(){
        DriverManagerTL.down();
    }

    protected void takeScreenshort(WebDriver driver){
        Allure.addAttachment("Screenshort",new ByteArrayInputStream
                (((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


}
