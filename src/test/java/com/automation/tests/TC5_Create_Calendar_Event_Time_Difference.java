package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TC5_Create_Calendar_Event_Time_Difference extends AbstractTestBase {

    @Test(description = "Verify time difference")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        int actualDif = calendarEventsPage.differenceStartAndEndTime();
        int expectedDif = 1;

        assertEquals(actualDif, expectedDif);

    }

}
