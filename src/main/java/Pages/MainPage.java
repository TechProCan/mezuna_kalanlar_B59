package Pages;

import Base.BaseStepMethod;
import Utilities.ConfigReader;

import static Base.BaseTest.driver;

public class MainPage extends BaseStepMethod {

    public MainPage(){

    }

    public void goTo_A101(){
       driver.get(ConfigReader.getProperty("baseURL"));
    }
}
