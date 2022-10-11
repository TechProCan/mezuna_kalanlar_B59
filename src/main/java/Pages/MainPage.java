package Pages;

import Base.BaseStepMethod;
import Utilities.ConfigReader;
import org.openqa.selenium.By;

import java.io.IOException;

import static Base.BaseTest.driver;

public class MainPage extends BaseStepMethod {

    public MainPage(){

    }
    private static final By BTN_MAINPAGE_COOKIES_ACCEPT =By.cssSelector("#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private static final By TXT_MAINPAGE_SEARCH_BOX =By.xpath("//input[@name='search_text']");


    public void goTo_A101() throws IOException {
       driver.get(ConfigReader.getProperty("baseURL"));
       checkStatusNetwork();

    }

    public void accept_cookies(){
        clickElement(BTN_MAINPAGE_COOKIES_ACCEPT);

    }

    public void searchBox(String aranacakKelime){
        sendTextElement(TXT_MAINPAGE_SEARCH_BOX,aranacakKelime);
    }
}
