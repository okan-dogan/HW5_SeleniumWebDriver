package com.automation.pages;

import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(xpath = "//*[text()='Testers Meeting']/../td[9]")
    private WebElement testersMeetingThreeDot;

    @FindBy(xpath = "//*[text()='Testers Meeting']/../td[9]//*[@class='dropdown-menu__placeholder']")
    private WebElement hoverOver;

    @FindBy(xpath = "//div[@class='loader-mask']/following-sibling::ul//a")
    private List<WebElement> icons;

    @FindBy(xpath = "//*[@title='Grid Settings']")
    private WebElement gridSettingsButton;

    @FindBy(xpath = "//table[@class='grid table-hover table table-condensed']//*[@type='checkbox']")
    private List<WebElement> gridSettingsCheckboxes;

    @FindBy(xpath = "//span[@class='grid-header-cell__label']")
    private List<WebElement> tableHeaders;

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEventButton;

    @FindBy(xpath = "//*[@href='#' and @data-toggle='dropdown']")
    private WebElement saveOptionsButton;

    @FindBy(xpath = "//ul//*[@type='submit']")
    private List<WebElement> saveOptions;

    @FindBy(xpath = "//*[@title='Cancel']")
    private WebElement createCalendarCancelButton;

    @FindBy(xpath = "//*[@class='oro-subtitle']")
    private WebElement calendarEventsSubtitle;

    @FindBy(xpath = "//*[contains(@id,'time_selector_oro_calendar_event_form_start-uid')]")
    private WebElement createCalendarEventStartTime;

    @FindBy(xpath = "//*[contains(@id,'time_selector_oro_calendar_event_form_end-uid')]")
    private WebElement createCalendarEventEndTime;

    @FindBy(xpath = "//*[contains(@id,'oro_calendar_event_form_allDay-uid')]")
    private WebElement allDayEventCheckBox;

    @FindBy(xpath = "//*[contains(@id,'date_selector_oro_calendar_event_form_start-uid')]")
    private WebElement createCalendarEventStartDate;

    @FindBy(xpath = "//*[contains(@id,'date_selector_oro_calendar_event_form_end-uid')]")
    private WebElement createCalendarEventEndDate;

    @FindBy(xpath = "//*[contains(@id,'recurrence-repeat') and @type='checkbox']")
    private WebElement createCalendarEventRepeatCheckox;

    @FindBy(xpath = "//select[contains(@id,'recurrence-repeats')]")
    private WebElement createCalendarEventRepeatOptionsClick;

    @FindBy(xpath = "(//*[text()='Repeat every']/../following-sibling::div//input)[1]")
    private WebElement repeatEveryRadioBut;

    @FindBy(xpath = "(//*[text()='Ends']/../following-sibling::div//input)[1]")
    private WebElement endsNeverRadioBut;

    @FindBy(xpath = "//*[contains(text(),'Summary')]")
    private WebElement summaryTitle;

    @FindBy(xpath = "//*[contains(text(),'Daily every')]")
    private WebElement summaryText1;

    @FindBy(xpath = "//*[contains(text(),'Daily every')]/following-sibling::span")
    private WebElement summaryText2;

    @FindBy(xpath = "//*[contains(text(),'Weekly every')]")
    private WebElement summaryText3;

    @FindBy(xpath = "(//*[text()='Ends']/../following-sibling::div//input)[2]")
    private WebElement endsAfterRadioBut;

    @FindBy(xpath = "(//*[text()='Ends']/../following-sibling::div//input)[2]/following-sibling::input")
    private WebElement endsAfterInput;

    @FindBy(xpath = "(//*[text()='Ends']/../following-sibling::div//input)[4]")
    private WebElement endsByRadioBut;

    @FindBy(xpath = "(//*[text()='Ends']/../following-sibling::div//input)[6]")
    private WebElement endsByInputDate;

    @FindBy(xpath = "(//*[text()='Ends']/../following-sibling::div//input)[7]")
    private WebElement endsByInputTime;

    @FindBy(xpath = "//*[@type='checkbox' and @value='monday']")
    private WebElement mondayCheckbox;

    @FindBy(xpath = "//*[@type='checkbox' and @value='friday']")
    private WebElement fridayCheckbox;

    public List<String> hoverOverThreeDot(){
        actions.moveToElement(testersMeetingThreeDot).pause(5000).perform();

        List<String> iconsNames = new ArrayList<>();
        for (WebElement eachIcon : icons) {
            actions.moveToElement(eachIcon).pause(1000).perform();
            iconsNames.add(eachIcon.getAttribute("title"));
        }

        return iconsNames;
    }


    public String getInfoSelectWeekly(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(5);

        createCalendarEventRepeatCheckox.click();
        BrowserUtilities.wait(2);

        createCalendarEventRepeatOptionsClick.click();
        Select select = new Select(createCalendarEventRepeatOptionsClick);
        select.selectByVisibleText("Weekly");
        BrowserUtilities.wait(2);

        mondayCheckbox.click();
        BrowserUtilities.wait(1);
        fridayCheckbox.click();
        BrowserUtilities.wait(1);

        String summaryTextFull = summaryTitle.getText()+" "+summaryText3.getText();

        return summaryTextFull;

    }


    public String getInfoEndsBy(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(5);

        createCalendarEventRepeatCheckox.click();
        BrowserUtilities.wait(2);

        endsByRadioBut.click();
        endsByInputDate.sendKeys("Nov 18, 2021", Keys.ESCAPE, Keys.ENTER);

        String summaryTextFull = summaryTitle.getText()+" "+summaryText1.getText()+summaryText2.getText();

        return summaryTextFull;

    }


    public String getInfoEndsAfter(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(5);

        createCalendarEventRepeatCheckox.click();
        BrowserUtilities.wait(2);

        endsAfterRadioBut.click();
        endsAfterInput.sendKeys("10", Keys.ENTER);

        String summaryTextFull = summaryTitle.getText()+" "+summaryText1.getText()+summaryText2.getText();

        return summaryTextFull;

    }


    public String getInfoAfterClickingRepeat(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(5);

        createCalendarEventRepeatCheckox.click();
        BrowserUtilities.wait(2);

        List<Boolean> isSelecteds = new ArrayList<>();
        boolean repeatIsSelected = createCalendarEventRepeatCheckox.isSelected();
        boolean repeatEveryIsSelected = repeatEveryRadioBut.isSelected();
        boolean endsNeverIsSelected = endsNeverRadioBut.isSelected();
        isSelecteds.add(repeatIsSelected);
        isSelecteds.add(repeatEveryIsSelected);
        isSelecteds.add(endsNeverIsSelected);
        String booleans = isSelecteds.toString();

        String summaryTextFull = summaryTitle.getText()+" "+summaryText1.getText()+" ";

        return summaryTextFull+booleans;

    }


    public List<String> getRepeatsOptions(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(5);

        createCalendarEventRepeatCheckox.click();
        BrowserUtilities.wait(2);

        createCalendarEventRepeatOptionsClick.click();
        Select select = new Select(createCalendarEventRepeatOptionsClick);
        String firstSelected = select.getFirstSelectedOption().getText();
        BrowserUtilities.wait(2);

        List<String> repeatsOptions =  new ArrayList<>();
        for (WebElement eachRepeatOption : select.getOptions()) {
            repeatsOptions.add(eachRepeatOption.getText());
        }

        if(firstSelected.equals("Daily")){
            return repeatsOptions;
        }else{
            throw new RuntimeException("Daily option is not selected as default!");
        }

    }


    public List<Boolean> getDateTimeDefaultDisplay(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(2);
        List<Boolean> dateTimeDisplayedDefaultList = new ArrayList<>();
        dateTimeDisplayedDefaultList.add(createCalendarEventStartDate.isDisplayed());
        dateTimeDisplayedDefaultList.add(createCalendarEventEndDate.isDisplayed());
        dateTimeDisplayedDefaultList.add(createCalendarEventStartTime.isDisplayed());
        dateTimeDisplayedDefaultList.add(createCalendarEventEndTime.isDisplayed());
        return dateTimeDisplayedDefaultList;
    }



    public List<Boolean> getDateTimeDisplayAfterClickingAllDay(){
        allDayEventCheckBox.click();
        BrowserUtilities.wait(3);
        List<Boolean> dateTimeDisplayedAfterClickingAllDayList = new ArrayList<>();
        dateTimeDisplayedAfterClickingAllDayList.add(createCalendarEventStartDate.isDisplayed());
        dateTimeDisplayedAfterClickingAllDayList.add(createCalendarEventEndDate.isDisplayed());
        dateTimeDisplayedAfterClickingAllDayList.add(createCalendarEventStartTime.isDisplayed());
        dateTimeDisplayedAfterClickingAllDayList.add(createCalendarEventEndTime.isDisplayed());
        return dateTimeDisplayedAfterClickingAllDayList;
    }



    public void selectStartTime(String time){
        createCalendarEventButton.click();
        BrowserUtilities.wait(2);
        createCalendarEventStartTime.click();
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        createCalendarEventStartTime.sendKeys(selectAll, Keys.BACK_SPACE);
        BrowserUtilities.wait(1);
        createCalendarEventStartTime.sendKeys(time, Keys.ENTER);
    }



    public String getStartTime(){
        BrowserUtilities.wait(2);
        return createCalendarEventStartTime.getAttribute("value");
    }



    public String getEndTime(){
        BrowserUtilities.wait(2);
        return createCalendarEventEndTime.getAttribute("value");
    }



    public int differenceStartAndEndTime(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(2);
        String startTime = createCalendarEventStartTime.getAttribute("value");
        String endTime = createCalendarEventEndTime.getAttribute("value");
        int st = Integer.parseInt(startTime.split(":")[0]);
        int et = Integer.parseInt(endTime.split(":")[0]);
        if(st==12){
            st/=12;
        }
        return Math.abs(st-et);
    }


    public String getSubtitle_afterClickingCancel(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(1);
        createCalendarCancelButton.click();
        BrowserUtilities.wait(1);
        return calendarEventsSubtitle.getText();
    }


    public List<String> clickSaveOptions(){
        createCalendarEventButton.click();
        BrowserUtilities.wait(2);
        actions.moveToElement(saveOptionsButton).click(saveOptionsButton).pause(2000).perform();
        List<String> saveOptionsNames = new ArrayList<>();
        for (int i = 0; i <saveOptions.size() ; i++) {
            saveOptionsNames.add(saveOptions.get(i).getText());
        }
        return saveOptionsNames;
    }



    public void deselect_All_Options_Except_Title(){
        gridSettingsButton.click();
        for (int i = 1; i <gridSettingsCheckboxes.size() ; i++) {
            gridSettingsCheckboxes.get(i).click();
            BrowserUtilities.wait(1);
        }
    }



    public List<String> getHeadersNames(){
        List<String> headersNames = new ArrayList<>();
        for (int i = 0; i <tableHeaders.size() ; i++) {
            headersNames.add(tableHeaders.get(i).getText());
        }
        return headersNames;
    }



}
