package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.io.Reader;
import java.util.concurrent.TimeUnit;





public class setupPageObject {

    public static WebDriver driver;

    private WebDriver createChromeDriver() throws Exception {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @BeforeClass
    public void setup() throws Throwable {
        driver = createChromeDriver();
        driver.manage().window().maximize();
    }




    }