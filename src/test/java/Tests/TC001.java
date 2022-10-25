package Tests;

import Base.BaseTest;
import Pages.AllPages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class TC001 extends BaseTest {

    private static final Logger LOGGER= LogManager.getLogger(TC001.class);
    AllPages allPages = new AllPages();

    @Test(description = "TC001")
    public void tc_001(Method method) throws IOException {

        allPages.mainPage().goTo_A101();
        allPages.mainPage().accept_cookies();
        allPages.mainPage().searchBox("elma"+ Keys.ENTER);

    }
}
