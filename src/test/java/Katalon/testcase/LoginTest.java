package Katalon.testcase;


import Katalon.driver.DriverManagerTL;
import Katalon.pages.HomePage;
import Katalon.pages.LoginPage;
import Katalon.testbase.TestBase;
import Katalon.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify a the invalid username or password")
    @Test(groups = {"P0","Negative"}, priority = 1)
    public void testLogin_negative() throws Exception {
        DriverManagerTL.getDriver().get(PropertyReader.readkey("url"));
        HomePage homePage = new HomePage();
        homePage.clickMakeAppointment();

        LoginPage loginPage = new LoginPage().LoginToKatalon(false);
        String login_error =loginPage.error_message_text();
        takeScreenshort(DriverManagerTL.getDriver());
        Assertions.assertThat(login_error)
                .isNotBlank().isNotNull().contains(PropertyReader.readkey("invalid_login"));

    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify a valid credential login successful")
    @Test(groups = {"P1","Positive"},priority = 2)
    public void testLogin_Positive() throws Exception {
        DriverManagerTL.getDriver().get(PropertyReader.readkey("url"));
        HomePage homePage = new HomePage();
        homePage.clickMakeAppointment();
        LoginPage loginPage = new LoginPage().LoginToKatalon(true);

        String expectedurl = PropertyReader.readkey("app_url");
        Assertions.assertThat(DriverManagerTL.getDriver().getCurrentUrl().contains(expectedurl));


    }
}
