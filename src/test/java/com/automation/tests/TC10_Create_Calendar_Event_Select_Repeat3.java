package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TC10_Create_Calendar_Event_Select_Repeat3 extends AbstractTestBase {

    @Test(description = "Verify some options after clicking 'repeat' checkbox")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String actualInfoAfterClickEndsAfter = calendarEventsPage.getInfoEndsAfter();
        String expectedInfoAfterClickEndsAfter = "Summary: Daily every 1 day, end after 10 occurrences";
        assertEquals(actualInfoAfterClickEndsAfter, expectedInfoAfterClickEndsAfter);

    }

}
