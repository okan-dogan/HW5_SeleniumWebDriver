package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TC9_Create_Calendar_Event_Select_Repeat2 extends AbstractTestBase {

    @Test(description = "Verify some options after clicking 'repeat' checkbox")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String actualInfoAfterClickingRepeat = calendarEventsPage.getInfoAfterClickingRepeat();
        String expectedInfoAfterClickingRepeat = "Summary: Daily every 1 day [true, true, true]";
        assertEquals(actualInfoAfterClickingRepeat, expectedInfoAfterClickingRepeat);

    }

}
