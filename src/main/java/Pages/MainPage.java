package Pages;

import Base.BaseStepMethod;
import Utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.io.IOException;

import static Base.BaseTest.driver;

public class MainPage extends BaseStepMethod {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);
    public MainPage(){

    }
    private static final By BTN_MAINPAGE_COOKIES_ACCEPT =By.cssSelector("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private static final By TXT_MAINPAGE_SEARCH_BOX =By.xpath("//input[@name='search_text']");


    public void goTo_A101() throws IOException {
       driver.get(ConfigReader.getProperty("baseURL"));
       LOGGER.info("User go to "+ConfigReader.getProperty("baseURL"));
       checkStatusNetwork();
       LOGGER.info("User check statusCode ");

    }

    public void accept_cookies(){
        clickElement(BTN_MAINPAGE_COOKIES_ACCEPT);
LOGGER.info("User click cookies");
    }

    public void searchBox(String aranacakKelime){
        sendTextElement(TXT_MAINPAGE_SEARCH_BOX,aranacakKelime);
        LOGGER.info("User send to "+aranacakKelime+" for searching");
    }
}
