package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TC7_Create_Calendar_Event_All_Day_Event extends AbstractTestBase {

    @Test(description = "Verify that 'time' boxes are NOT displayed and 'date' boxes are displayed")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String actualDateTimeDefaultDisplay = calendarEventsPage.getDateTimeDefaultDisplay().toString();
        String expectedDateTimeDefaultDisplay = "[true, true, true, true]";
        assertEquals(actualDateTimeDefaultDisplay, expectedDateTimeDefaultDisplay);

        String actualDateTimeDisplayAfterAllDay = calendarEventsPage.getDateTimeDisplayAfterClickingAllDay().toString();
        String expectedDateTimeDisplayAfterAllDay = "[true, true, false, false]";
        assertEquals(actualDateTimeDisplayAfterAllDay, expectedDateTimeDisplayAfterAllDay);

    }

}
