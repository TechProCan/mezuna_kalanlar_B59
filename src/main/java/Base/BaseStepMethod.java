package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    protected String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    protected void clickElement(By locator) {
        WebElement element = this.waitVisibleByLocator(locator);
        waitClickableByOfElement(element).click();
    }


}
