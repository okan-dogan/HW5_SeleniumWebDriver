package com.automation.tests;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTestBase {
    public WebDriver driver;
    public Actions action;


    @BeforeMethod
    public void setup(){
        driver= Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("environment1"));
        BrowserUtilities.wait(1);
        action = new Actions(driver);
    }


//    @AfterMethod
//    public void teardown(){
//        BrowserUtilities.wait(1);
//        Driver.closeDriver();
//    }


}
