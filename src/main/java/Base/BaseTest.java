package Base;


import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;



public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;

    public synchronized static WebDriver getDriver() {
        return driver;
    }

    public synchronized static WebDriver setDriver(String browser) {

        if (driver == null) {
            // buraya yazilan ifin nedeni bu method her calistiginda yeni bir driver olusturmamasi icin kullaniyoruz.
            // if driveri kontrol edecek eger bir deger atamasi yapildiysa yeni bir driver olusturmayacak.

            browser = browser == null ? ConfigReader.getProperty("browser") : browser;

            // EMNIYET SUBABI : YUKARIDAKI ISLEM BROWSER A DEGER ATAMAZSAM BIZE CONFIG READER DAN DEGER AL DEMEKTIR.

            switch (browser) {
                // case i driveri istedgimimz browserda calistirmak icin kullanmaliyiz.
                // configuration.properties dosyasinda browser olarak ne yazdiysak tum testlerimiz o browserda calisacak

                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    options.addArguments("--start-maximized");
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("--allow-insecure-localhost");
                    options.addArguments("--acceptInsecureCerts");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-private-window");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

        }
        return driver;
    }

    //Do the test setup
    @BeforeClass
    @Parameters(value = {"browser"})
    public synchronized void setupTest(@Optional String browser) throws MalformedURLException {
        //Set & Get ThreadLocal Driver with Browser
        driver = setDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }

    @AfterClass
    public synchronized void tearDown() throws Exception {
        if (driver != null) {
            //driver.close();
        }
        driver = null;

        // burada yeniden null degeri atamamizin sebebi bir sonraki getDriver methodu cagirisimizda yeni bir deger atayabilmek istememizidir.
    }


}
