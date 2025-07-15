package Katalon.testcase;

import Katalon.driver.DriverManagerTL;
import Katalon.pages.*;
import Katalon.testbase.TestBase;
import Katalon.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.*;


public class AppointmentBookTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MakeAppointment makeAppointment;
    AppointmentSummary summary;


    @BeforeMethod
    public void loginBeforeTest() throws Exception {
        DriverManagerTL.getDriver().get(PropertyReader.readkey("url"));

        homePage = new HomePage();
        loginPage = homePage.clickMakeAppointment();
        loginPage.LoginToKatalon(true);

    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify a Appointment summary")
    @Test(groups = {"PO", "Positive"}, priority = 3)
    public void AppointmentTest() throws Exception {

        makeAppointment = new MakeAppointment();
        makeAppointment.BookToAppointment();

        summary = new AppointmentSummary();
        String confirmation = summary.LoggedInInformation();
        String facility = summary.getFacility();
        String hospital = summary.getHospitalRead();
        String program = summary.getHealthProgram();
        String VDate = summary.getVisitDate();
        String comm = summary.getComment();

        Assertions.assertThat(confirmation)
                .isNotNull().contains(PropertyReader.readkey("confirmation"));
        Assertions.assertThat(facility)
                .isNotNull().contains(PropertyReader.readkey("facility"));
        Assertions.assertThat(hospital)
                .isNotNull().contains(PropertyReader.readkey("hospital_readmission"));
        Assertions.assertThat(program)
                .isNotBlank().contains(PropertyReader.readkey("healthcare_program"));
        Assertions.assertThat(VDate)
                .isNotBlank().contains(PropertyReader.readkey("visit_date"));
        Assertions.assertThat(comm)
                .isNotBlank().isEqualToIgnoringCase(PropertyReader.readkey("comment"));
    }

    @AfterMethod
    public void logoutAfterTest() {

        LogoutPage logoutPage = new LogoutPage();
        logoutPage.LogoutUser();
    }


}
