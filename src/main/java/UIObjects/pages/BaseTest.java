package UIObjects.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.function.Function;
import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;
    protected PageContainer agent;
    public static final Logger logger = Logger.getGlobal();

    public void agentCount() {
        driver = new ChromeDriver();
        agent = new PageContainer(driver);
    }

    @BeforeSuite
    public void setUpChromeDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initChromeDriver() {
        driver = new ChromeDriver();
        agent = new PageContainer(driver);
    }

    public void openUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void changeWindowSize(int width, int height) {
        logger.info("Change window size");
        Dimension size = new Dimension(width, height);
        agent.getDriver().manage().window().setSize(size);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(ITestResult result) {
        if (!result.isSuccess()) {
            Allure.getLifecycle().addAttachment(
                    "screenshot", "image/png", "png",
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
        agent.getDriver().quit();
    }

    public void doubleClick(WebElement element) {
        new Actions(agent.getDriver()).doubleClick(element).build().perform();
    }

    public void hoverElement(WebElement element) {
        new Actions(agent.getDriver()).moveToElement(element).build().perform();
    }

    public void waitForElementVisibility(WebElement element, int timeout) {
        new WebDriverWait(agent.getDriver(), Duration.ofSeconds(timeout)).until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public static boolean waitForCondition(WebDriver driver, Function<WebDriver, Boolean> condition, int timeout) {
        return new FluentWait<>(driver)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(condition);
    }
}
