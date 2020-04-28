package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TC12_Create_Calendar_Event_Select_Repeat5 extends AbstractTestBase {

    @Test(description = "Verify some options after clicking 'repeat' checkbox")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String actualInfoAfterSelectWeekly = calendarEventsPage.getInfoSelectWeekly();
        String expectedInfoAfterSelectWeekly = "Summary: Weekly every 1 week on Monday, Friday";
        assertEquals(actualInfoAfterSelectWeekly, expectedInfoAfterSelectWeekly);

    }

}
