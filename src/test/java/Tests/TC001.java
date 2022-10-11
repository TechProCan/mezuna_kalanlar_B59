package Tests;

import Base.BaseTest;
import Pages.AllPages;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class TC001 extends BaseTest {

    AllPages allPages = new AllPages();

    @Test(description = "TC001")
    public void tc_001(Method method) throws IOException {
        allPages.mainPage().goTo_A101();
        allPages.mainPage().accept_cookies();
        allPages.mainPage().searchBox("elma"+ Keys.ENTER);

    }
}
