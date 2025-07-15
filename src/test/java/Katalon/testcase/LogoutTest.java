package Katalon.testcase;

import Katalon.pages.LogoutPage;
import Katalon.testbase.TestBase;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {

    @Test
    public void testLogout(){

        LogoutPage logoutPage = new LogoutPage();
        logoutPage.LogoutUser();

    }

}
