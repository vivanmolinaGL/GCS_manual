package pages;

import helpers.setupPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class commonActions extends setupPageObject {

    public static void getTestUrl() {

        driver.get("https://services-test.digitalglobe.com/myDigitalGlobeAdmin/RegistrationRequest.html");
        boolean isThePageTitleCorrect = driver.getTitle().matches("My DigitalGlobe Registration");
        Assert.assertTrue(isThePageTitleCorrect, "ERROR> The page title does not match");

    }

    public static void clickIdButton(String path){


        driver.findElement(By.id(path)).click();

    }

    public static void enterTextToTextField (String pathTextField, String formText){

        driver.findElement(By.id(pathTextField)).sendKeys(formText);


    }

    public static void selectOptionFromDropdown (String pathDropdown, int optionIndex){

        Select dropdown = new  Select(driver.findElement(By.id(pathDropdown)));

        dropdown.selectByIndex(optionIndex);


    }

    public static void assertDropdownDescription (String pathDescription) {

        boolean isDescriptionPresent = driver.findElement(By.id(pathDescription)).isDisplayed();
        Assert.assertTrue(isDescriptionPresent, "Description is not present");
        String descriptionMessageText = driver.findElement(By.id(pathDescription)).getText();
        System.out.println("INFO > The description is: " + descriptionMessageText);


    }

    public static void assertErrorMessage () {

        boolean isTheErrorMessagePresent = driver.findElement(By.xpath("//*[@id='center_column']/div/p")).isDisplayed();
        Assert.assertTrue(isTheErrorMessagePresent, "Error message is not present");
        String errorMessageText = driver.findElement(By.xpath("//*[@id='center_column']/div/p")).getText();
        System.out.println("INFO > The displayed error message is: " + errorMessageText);

    }

    public static void assertSuccessMessage () {

        boolean isSuccessAlertPresent = driver.findElement(By.xpath("//*[@id='center_column']/*")).isDisplayed();
        Assert.assertTrue(isSuccessAlertPresent, "Success message is not present");
        String successAlertMessageText = driver.findElement(By.xpath("//*[@id='center_column']/*")).getText();
        System.out.println("INFO > The success alert is: " + successAlertMessageText);

    }

    public static void clickClassButton (String classPathButton) {

        driver.findElement(By.className(classPathButton)).click();


    }

    public static void clickCssSelectorButton (String cssSelectorPath){

        driver.findElement(By.cssSelector(cssSelectorPath)).click();

    }

    public static void clickByLinkText (String linkSelectorPath){

        driver.findElement(By.linkText(linkSelectorPath)).click();

    }

    public static void clickByXpath (String linkXPath){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement element = driver.findElement(By.xpath(linkXPath));

        Actions actions = new Actions(driver);

        actions.moveToElement(element).click().perform();

       driver.findElement(By.xpath(linkXPath)).click();

    }


    public static void explicitWait (String elementPath) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5 );
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(elementPath)));
        }
        catch (TimeoutException ex){
            System.out.println("ERROR > Driver couldn't find element");
            driver.quit();
        }}

    public static void assertPage (String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("INFO > The current URL is: " + currentUrl);
        boolean isCurrentUrlCorrect = driver.getCurrentUrl().matches(expectedUrl);
        Assert.assertTrue(isCurrentUrlCorrect, "ERROR > Incorrect URL");

    }

    public static void assertElementByClass (String elementPathInPage){
        boolean isElementPresent = driver.findElement(By.className(elementPathInPage)).isDisplayed();
        Assert.assertTrue(isElementPresent, "Element is not present");
        String elementPresentText = driver.findElement(By.className(elementPathInPage)).getText();
        System.out.println("INFO > The element present is: " + elementPresentText);

    }

    public static void assertElementByCss (String elementPathCss){
        boolean isElementPresent = driver.findElement(By.cssSelector(elementPathCss)).isDisplayed();
        Assert.assertTrue(isElementPresent, "Element is not present");
        String elementPresentText = driver.findElement(By.cssSelector(elementPathCss)).getText();
        System.out.println("INFO > " + elementPresentText);

    }

    public static void assertElementById (String elementPathId){

        String elementPresentText = driver.findElement(By.id(elementPathId)).getText();
        System.out.println("INFO > " + elementPresentText);
        boolean isElementPresent = driver.findElement(By.id(elementPathId)).isDisplayed();
        Assert.assertTrue(isElementPresent, "Element is not present");


    }

    public static void assertElementByXpath (String elementXpath) {

        boolean isTheErrorMessagePresent = driver.findElement(By.xpath(elementXpath)).isDisplayed();
        Assert.assertTrue(isTheErrorMessagePresent, "Error message is not present");
        String errorMessageText = driver.findElement(By.xpath(elementXpath)).getText();
        System.out.println("INFO > The displayed element is: " + errorMessageText);

    }



}
