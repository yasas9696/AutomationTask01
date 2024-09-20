package com.wp.testautomation01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class MainPage {


    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementButton;

    @FindBy(xpath = "//span[text() = 'Text Box']")
    public WebElement spanTextBox;

    @FindBy(xpath = "//span[text() = 'Check Box']")
    public WebElement spanCheckBox;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/span/button")
    public WebElement svgIconExpand;

    @FindBy(xpath = "//span[text() = 'Radio Button']")
    public WebElement spanRadioButtonBox;

    @FindBy(xpath = "//span[text() = 'Buttons']")
    public WebElement spanButtonsBox;

    @FindBy(xpath = "//h5[text()='Widgets']")
    public WebElement widgetsButton;

    @FindBy(xpath = "//span[text() = 'Date Picker']")
    public WebElement spanDatepicker;

    @FindBy(xpath = "//h5[text() = 'Alerts, Frame & Windows']")
    public WebElement alertButton;

    @FindBy(xpath = "//span[text() = 'Modal Dialogs']")
    public WebElement spanModalDialogs;

    @FindBy(xpath = "//span[text() = 'Links']")
    public WebElement spanLinks;





    

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
