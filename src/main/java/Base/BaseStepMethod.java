package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import static Base.BaseTest.driver;

public class BaseStepMethod {
    private WebDriverWait wait;

    public BaseStepMethod() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected WebElement waitVisibleByLocator(By locator) {
        WebElement element = null;

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
           // LOGGER.error("Web element is not visible!");
        }
        return element;
    }
    protected WebElement waitClickableByOfElement(WebElement webElement) {
        WebElement element = null;

        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
           // LOGGER.error("Web element is not clickable!");
        }
        return element;
    }
    protected WebElement waitPresenceOfElementByLocator(By locator) {
        WebElement element = null;

        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
           // LOGGER.error("Web element not found in document!");
        }
        return element;
    }
//-------------------------------------------------------------
    protected String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    protected void clickElement(By locator) {
        WebElement element = this.waitVisibleByLocator(locator);
        waitClickableByOfElement(element).click();
    }
    protected void hoverElement(By locator, int second) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator)).pause(Duration.ofSeconds(second)).perform();

    }
    protected void dragAndDrop(By locator1,By locator2,int second){
        Actions action =new Actions(driver);
        action.dragAndDrop(driver.findElement(locator1),driver.findElement(locator2)).pause(Duration.ofSeconds(second)).perform();
    }
    protected void checkStatusNetwork() throws IOException {
        // LOGGER.info("User connecting to the Http Network status of the page.");
        // getTest().info("User connecting to the Http Network status of the page.");

        HttpURLConnection cn = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();

        cn.setRequestMethod("HEAD");
        cn.connect();
        Integer c = cn.getResponseCode();
        System.out.println("Response Code : "+c);

        //  LOGGER.info(driver.getCurrentUrl() + " Http status code: " + c);
        //  getTest().info(driver.getCurrentUrl() + " Http status code: " + c);

        Assert.assertFalse(c.toString().startsWith("4") || c.toString().startsWith("5"), c + "Invalid Link " + driver.getCurrentUrl());
        cn.disconnect();
    }

    protected String getTextElement(By locator) {
        return waitPresenceOfElementByLocator(locator).getText();
    }

    protected WebElement sendTextElement(By locator, String text) {
        WebElement element = waitPresenceOfElementByLocator(locator);
        element.clear();
        element.sendKeys(text);

        return element;
    }

    protected boolean isDisplayElement(By locator) {
        WebElement element = waitPresenceOfElementByLocator(locator);
        return element.isDisplayed();
    }
    protected boolean isEnableElement(By locator) {
        WebElement element = waitPresenceOfElementByLocator(locator);
        return element.isEnabled();
    }

    protected String getAttributeElement(By locator, String attribute) {
        WebElement element = this.waitVisibleByLocator(locator);
        return element.getAttribute(attribute);
    }


    protected String getTabTitle() {
        return driver.getTitle();
    }







}
