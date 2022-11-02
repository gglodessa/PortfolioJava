package regression;
//Добавили в свойства ChromeDriver, убрали System.setProperty.
// Написали тест с использованием after and before метод, добавили BeforeSuite для проверки версии браузера и скачивает драйвер для нее.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;



public class Test3 {

    private WebDriver driver;

    @BeforeSuite
    public void downloadDriver(){
        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Установка размера окна
        /*ChromeOptions options = new ChromeOptions()
                .setLogLevel(ChromeDriverLogLevel.INFO)
                .addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);*/
    }

    @Test
    public void lessonsNumberNine() {

        driver.get("https://www.google.com");

        assertEquals(driver.getTitle(), "Google", "good job");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
