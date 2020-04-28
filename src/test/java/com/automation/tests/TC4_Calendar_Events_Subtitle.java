package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TC4_Calendar_Events_Subtitle extends AbstractTestBase {

    @Test(description = "Verify subtitle")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String actualSubtitle = calendarEventsPage.getSubtitle_afterClickingCancel();
        String expectedSubtitle = "All Calendar Events";

        assertEquals(actualSubtitle, expectedSubtitle);

    }

}
