package com.automation.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {

    private static WebDriver driver = Driver.getDriver();

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void waitForPageToLoad(int second){
        ExpectedCondition<Boolean> expectedCondition = webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver,second);
        wait.until(expectedCondition);
    }




}
