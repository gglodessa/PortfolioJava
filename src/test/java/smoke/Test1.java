package smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Test1 {
    private WebDriver driver;
    public static final Logger logger = Logger.getGlobal();

    @BeforeSuite
    public void downloadDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void logIn() {
        logger.info("1. Sign In");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        logger.info("2. Check basket");
        assertFalse(driver.findElements(By.id("shopping_cart_container")).isEmpty(),
                "User is not logged in shopping cart icon not found");
    }

    @Test
    public void wrongPassworld() {
        logger.info("1. Sign in with wrong password");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauc");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        logger.info(("2. Check error message"));
        assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Epic sadface:')]")).getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Login failed");
    }

    @Test
    public void lockedOutUser() {
        logger.info("1. Sign in with used locked_out_user");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        logger.info(("2. Check error message"));
        assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Epic sadface:')]")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Login locked");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
