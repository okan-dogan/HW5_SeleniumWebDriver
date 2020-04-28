package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class TC2_Grid_Settings extends AbstractTestBase {

    @Test(description = "Verify that 'Grid Setting' checkboxes selectable and deselectable")
    public void verify_Grid_Settings_Selections(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.deselect_All_Options_Except_Title();

        String actualHeaderName = calendarEventsPage.getHeadersNames().toString();
        String expectedHeaderName = "[TITLE, ]";

        assertEquals(actualHeaderName, expectedHeaderName);

    }

}
