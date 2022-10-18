package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class  Test1 {
    public static final Logger logger = Logger.getGlobal();


    @Test
    public void AddAndDeleteElements() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\olexiy.klein\\IdeaProjects\\AQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        try {
            logger.info("1. Open page and full screen mode");
            driver.get("http://the-internet.herokuapp.com/");
            driver.manage().window().maximize();

            logger.info("2.Check that we are on the required page Go to Forgot Add/Remove Elements");
            driver.findElement(By.xpath("//a[@href='/add_remove_elements/']")).click();

            logger.info("3.Сheck that we are on the required page and click 5 times on add element");
            String checkPage = driver.findElement(By.cssSelector("body h3")).getText();
            Assert.assertEquals(checkPage, "Add/Remove Elements", "Opened page");
            WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
            for (int i =0; i < 5; i++) {
                addElement.click();
            }

            logger.info("4. Make sure 5 items appear");
            List<WebElement> fiveElements = driver.findElements(By.className("added-manually"));
            Assert.assertEquals(fiveElements.size(), 5, "Find five elements");


            logger.info("5. Сlick on two elements and make sure there are 3 left");
            fiveElements.get(3).click();
            fiveElements.get(2).click();
            List<WebElement> ThreeElements = driver.findElements(By.className("added-manually"));
            Assert.assertEquals(ThreeElements.size(),3, "left 3 elements" );

        } finally {
            driver.quit();
        }

    }

    @Test

    public void NativelyGETRequest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\olexiy.klein\\IdeaProjects\\AQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        try {

            logger.info("1. Open page and full screen mode");
            driver.get("http://the-internet.herokuapp.com/");
            driver.manage().window().maximize();


        } finally {
            driver.quit();
        }

    }
}

