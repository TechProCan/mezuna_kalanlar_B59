package Pages;

import Base.BaseStepMethod;
import Utilities.ConfigReader;
import org.openqa.selenium.By;

import static Base.BaseTest.driver;

public class MainPage extends BaseStepMethod {

    public MainPage(){

    }
    private static final By BTN_MAINPAGE_COOKIES_ACCEPT =By.cssSelector("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    public void goTo_A101(){
       driver.get(ConfigReader.getProperty("baseURL"));
    }

    public void accept_cookies(){
        clickElement(BTN_MAINPAGE_COOKIES_ACCEPT);
    }
}
