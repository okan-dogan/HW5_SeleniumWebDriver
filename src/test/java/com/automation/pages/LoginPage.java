package com.automation.pages;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageBase{

    @FindBy(css = "[id='prependedInput']")
    private WebElement userName;

    @FindBy(css = "[id='prependedInput2']")
    private WebElement password;

    @FindBy(css = "[id='_submit']")
    private WebElement submitButton;

    public void login_As_A_Store_Manager(){
        userName.sendKeys(ConfigurationReader.getProperty("storemanager"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        submitButton.click();
        BrowserUtilities.waitForPageToLoad(10);
    }


}
