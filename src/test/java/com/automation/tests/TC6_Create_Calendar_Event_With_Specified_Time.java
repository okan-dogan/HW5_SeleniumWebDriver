package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TC6_Create_Calendar_Event_With_Specified_Time extends AbstractTestBase {

    @Test(description = "Verify time difference")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.selectStartTime("9:00 PM");

        String actualStartTime = calendarEventsPage.getStartTime();
        String expectedStartTime = "9:00 PM";
        assertEquals(actualStartTime, expectedStartTime);

        String actualEndTime = calendarEventsPage.getEndTime();
        String expectedEndTime = "10:00 PM";
        assertEquals(actualStartTime, expectedStartTime);

    }

}
