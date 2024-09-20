package com.wp.testautomation01;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;




    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }




    //1. Test Case: Validate the 'Text Box' form submission
    @Test
    public void elementsTextBoxClick(){
        //element button click
        mainPage.elementButton.click();
        //click textbox button
        mainPage.spanTextBox.click();


        //Enter userName
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='userName']"));
        usernameField.sendKeys("John Doe");
        //Enter Email
        WebElement emailField = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailField.sendKeys("john@example.com");
        //Enter Current Address
        WebElement currentAddressField = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddressField.sendKeys("123 Street, City");
        //Enter Current Address
        WebElement permanentAddressField = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddressField.sendKeys("456 Avenue, City");
        //scroll
        WebElement element = driver.findElement(By.xpath("//button[@id='submit']"));
        //scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        //Submit Button Click
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
        //check username value
        WebElement viewUsernameField = driver.findElement(By.xpath("//p[@id='name']"));
        assertEquals(viewUsernameField.getText(), "Name:John Doe");
        //check email value
        WebElement viewEmailField = driver.findElement(By.xpath("//p[@id='email']"));
        assertEquals(viewEmailField.getText(),"Email:john@example.com");
        //check Current Address value
        WebElement viewCurrentAddressField = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        assertEquals(viewCurrentAddressField.getText(),"Current Address :123 Street, City");
        //check Permanent Address value
        WebElement viewPermanentAddressField = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        assertEquals(viewPermanentAddressField.getText(),"Permananet Address :456 Avenue, City");


    }

    //2. Test Case: Verify checkbox selection
    @Test
    public void elementsCheckBoxClick(){
        // Add a wait to ensure the elements are clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //element button click
        mainPage.elementButton.click();
        //checkBox button click
        mainPage.spanCheckBox.click();
        //expand svg arrow
        mainPage.svgIconExpand.click();

        // Locate the checkbox element
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Desktop']")));
        ////*[@id="tree-node"]/ol/li/ol/li[1]/span/label/span[3]

        // Check if the checkbox is not already selected
        if (!checkbox.isSelected()) {
            checkbox.click(); // Click the checkbox to select it
        }
        //check selected value
        WebElement viewSelectedCheckBox = driver.findElement(By.xpath("//span[text()='You have selected :']"));
        assertEquals(viewSelectedCheckBox.getText(),"You have selected :");
        //check desktop selected
        WebElement viewSelectedCheckBoxTextDesktop = driver.findElement(By.xpath("//span[text()='desktop']"));
        assertEquals(viewSelectedCheckBoxTextDesktop.getText(),"desktop");
        //check notes selected
        WebElement viewSelectedCheckBoxTextNotes = driver.findElement(By.xpath("//span[text()='notes']"));
        assertEquals(viewSelectedCheckBoxTextNotes.getText(),"notes");
        //check commands selected
        WebElement viewSelectedCheckBoxTextCommands = driver.findElement(By.xpath("//span[text()='commands']"));
        assertEquals(viewSelectedCheckBoxTextCommands.getText(),"commands");

    }

    //3. Test Case: Validate the 'Radio Button' functionality
    @Test
    public void elementsRadioButtonClick() {
        // Add a wait to ensure the elements are clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //element button click
        mainPage.elementButton.click();
        //radio button click
        mainPage.spanRadioButtonBox.click();

        //click yes radio button
        WebElement radioButtonYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioButtonYes.click();

        //check selected value
        WebElement viewSelectedRadioButton = driver.findElement(By.xpath("//span[@class='text-success']"));
        assertEquals(viewSelectedRadioButton.getText(),"Yes");

    }

    //4. Test Case: Test 'Buttons' page for button clicks
    @Test
    public void elementsButtonsClick() {
        // Add a wait to ensure the elements are clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //element button click
        mainPage.elementButton.click();
        //Buttons element click
        mainPage.spanButtonsBox.click();

        // Locate the double-click button element
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform double-click action on the button
        actions.doubleClick(doubleClickButton).perform();


        // Locate the single-click button element
        WebElement singleClickButton = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/button"));
        singleClickButton.click();

        //check Double click button correctly clicked
        WebElement viewSelectedButtonValue = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
        assertEquals(viewSelectedButtonValue.getText(),"You have done a double click");


        //check dynamic click button correctly clicked
        WebElement viewSelectedDynamicButton = driver.findElement(By.xpath(" //p[@id='dynamicClickMessage']"));
        assertEquals(viewSelectedDynamicButton.getText(),"You have done a dynamic click");

    }

    //5. Test Case: Validate the date picker functionality
    @Test
    public void widgetsDatePickerClick() {
        // Add a wait to ensure the elements are clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //widgets button click
        mainPage.widgetsButton.click();
        //datepicker widget click
        mainPage.spanDatepicker.click();

        //click date input field
        WebElement dateInputField = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
        dateInputField.click();

        // Wait until the calendar is visible (adjust the XPath for your specific calendar implementation)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month")));


        // Locate and click the desired date
        WebElement day = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='15']"));
        day.click();

        //check selected date value
        WebElement viewDateField = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
        assertEquals(viewDateField.getAttribute("value"), "09/15/2024");

    }


    //6. Test Case: Verify the 'Modal Dialogs' functionality
    @Test
    public void alertModalClick(){
        // Add a wait to ensure the elements are clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //alert button click
        mainPage.alertButton.click();
        //modal alert clicks
        mainPage.spanModalDialogs.click();

        //click small modal button
        WebElement smallModalButton = driver.findElement(By.xpath("//button[@id='showSmallModal']"));
        smallModalButton.click();
        // Verify the small modal is displayed
        WebElement smallModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='example-modal-sizes-title-sm']")));
        assertTrue(smallModal.isDisplayed(), "Expected Result: The small modal should appear.");

        // Click the 'Close' button with a retry mechanism
        try {
            WebElement closeModalButton = driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
            closeModalButton.click();
        } catch (StaleElementReferenceException e) {
            WebElement closeModalButton = driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
            closeModalButton.click();
        }

        // Verify the modal is no longer displayed
        wait.until(ExpectedConditions.invisibilityOf(smallModal));
        assertFalse(smallModal.isDisplayed(), "Expected Result: The small modal should close correctly when the 'Close' button is clicked.");


    }

   // 7. Test Case: Validate the 'Links' redirection
    @Test
    public void validateLinkClick(){
        // Add a wait to ensure the elements are clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //element button click
        mainPage.elementButton.click();
        //links button clicks
        mainPage.spanLinks.click();

        // Get the current window handle (main window)
        String originalWindow = driver.getWindowHandle();

        //click home link
        WebElement homeLink = driver.findElement(By.xpath("//a[@id='simpleLink']"));
        homeLink.click();

        // Wait for a new window or tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to the new tab/window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Wait for the URL to change to the home page URL
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/"));

        // Assert that the current URL is the expected home page URL
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://demoqa.com/", "Expected Result: The user should be redirected to the home page of the DEMOQA site.");

        // Close the new tab and switch back to the original window
        driver.close();
        driver.switchTo().window(originalWindow);

    }


}
