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
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\olexiy.klein\\IdeaProjects\\AQA\\chromedriver.exe");
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
            for (int i = 0; i < 5; i++) {
                addElement.click();
            }

            logger.info("4. Make sure 5 items appear");
            List<WebElement> fiveElements = driver.findElements(By.className("added-manually"));
            Assert.assertEquals(fiveElements.size(), 5, "Find five elements");


            logger.info("5. Сlick on two elements and make sure there are 3 left");
            fiveElements.get(3).click();
            fiveElements.get(2).click();
            List<WebElement> ThreeElements = driver.findElements(By.className("added-manually"));
            Assert.assertEquals(ThreeElements.size(), 3, "left 3 elements");

        } finally {
            driver.quit();
        }

    }

    @Test

    public void downloadUpload() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\olexiy.klein\\IdeaProjects\\AQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        try {

            logger.info("1. Open page and full screen mode");
            driver.get("http://the-internet.herokuapp.com/");
            driver.manage().window().maximize();

            logger.info("2. Go to File Download");
            driver.findElement(By.xpath("//*/ul/li[17]/a")).click();

            logger.info("3. Download sample.png file");
            driver.findElement(By.xpath("//a[@href='download/sample.png']")).click();

            logger.info("4. Back to start page");
            driver.navigate().back();

            logger.info("5. Check that the start page has opened");
            String startPage = driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).getText();
            Assert.assertEquals(startPage, "Elemental Selenium", "Check#1");

            logger.info("6. Go to File Uploaded");
            driver.findElement(By.xpath("//a[@href='/upload']")).click();

            logger.info("7. Add downloaded file to Select file");
            driver.findElement(By.id("file-upload")).sendKeys("C:/Users/olexiy.klein/Downloads/sample.png");

            logger.info("8. Click Upload");
            driver.findElement(By.className("button")).click();

            logger.info("9. Check if a message is displayed");
            String fileUpload  = driver.findElement(By.xpath("//div[@class='example']")).getText();
            Assert.assertEquals(fileUpload, "File Uploaded!\nsample.png", "Check#2");


        } finally {
            driver.quit();
        }
    }

    @Test

        public void CheckCheckboxes() {
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\olexiy.klein\\IdeaProjects\\AQA\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();


            try {

                logger.info("1. Open page and full screen mode");
                driver.get("http://the-internet.herokuapp.com/");
                driver.manage().window().maximize();

                logger.info("2. Go to Checkboxes");
                driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();

                logger.info("3. Remove Checkboxes 2 and check that Checkboxes 2 is removed");
                driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();
                WebElement unChecked = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
                Assert.assertEquals(unChecked.isSelected(), false, "checked");


                logger.info("4. Install Checkboxes 1 and check that Checkboxes 1 is installed");
                driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).click();
                WebElement checked =driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
                Assert.assertEquals(checked.isSelected(), true, "check#2");




            } finally {
                driver.quit();
            }
        }
    }

