package Tests;

import Base.BaseTest;
import Pages.AllPages;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TC001 extends BaseTest {

    AllPages allPages = new AllPages();

    @Test(description = "TC001")
    public void tc_001(Method method){
        allPages.mainPage().goTo_A101();

    }
}
