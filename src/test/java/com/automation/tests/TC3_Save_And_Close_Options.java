package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertEquals;


public class TC3_Save_And_Close_Options extends AbstractTestBase {

    @Test(description = "Verify that 'Save and Close' options available")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String actualSaveOptions = calendarEventsPage.clickSaveOptions().toString();
        String expectedSaveOptions = "[Save And Close, Save And New, Save]";

        assertEquals(actualSaveOptions, expectedSaveOptions);

    }

}
