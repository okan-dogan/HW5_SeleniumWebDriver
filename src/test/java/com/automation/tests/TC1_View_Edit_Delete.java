package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class TC1_View_Edit_Delete extends AbstractTestBase {

    @Test(description = "Verify that 'view', 'edit', 'delete' options are available")
    public void verify_View_Edit_Delete(){

        LoginPage loginPage = new LoginPage();
        loginPage.login_As_A_Store_Manager();
        loginPage.navigateTo("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        List<String> actualListOfIcons = calendarEventsPage.hoverOverThreeDot();
        List<String> expectedListOfIcons = Arrays.asList("View","Edit","Delete");

        assertEquals(actualListOfIcons, expectedListOfIcons);

    }

}
