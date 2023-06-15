package seleniumAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;
    public static final Logger logger = Logger.getGlobal();

    @BeforeSuite
    public void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initChromeDriver() {
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}