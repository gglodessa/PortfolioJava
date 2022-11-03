package smoke;
//Установка чекбоксов через условия

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class Test2 {
    private WebDriver driver;
    public static final Logger logger = Logger.getGlobal();

    @BeforeSuite
    public void downloadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void checkBox() {
        logger.info("1. Go to Checkboxes");
        driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();

        logger.info("2. Check that if checkbox 1 is false set it to true");
        WebElement checkboxTrue = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        boolean bool1 = checkboxTrue.isSelected();
        if (bool1 == false) {
            checkboxTrue.click();
        }

        logger.info("3. Check that if checkbox 2 is true set it to false");

        WebElement checkboxFalse = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        boolean bool2 = checkboxFalse.isSelected();
        if (bool2 == true) {
            checkboxFalse.click();
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}