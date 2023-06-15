package seleniumAdvanced;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertThrows;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitTest extends BaseTest {

    @BeforeMethod(groups = {"scriptTimeout", "implicitlyWait"})
    void openSampleApp() {
        driver.get("http://uitestingplayground.com/ajax");
    }

    @Test(groups = "implicitlyWait")
    void testImplicitlyWaitIncreased() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("ajaxButton")).click();
        assertFalse(driver.findElements(By.xpath("//p[text()='Data loaded with AJAX get request.']")).isEmpty(),
                "AJAX Data was not loaded");
    }

    @Test(groups = "implicitlyWait")
    void testImplicitlyWaitThrowsException() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("ajaxButton")).click();
        assertThrows(NoSuchElementException.class,
                () -> driver.findElement(By.xpath("//p[text()='Data loaded with AJAX get request.']")));
    }

    @Test(groups = "scriptTimeout")
    void testScriptTimeoutIncreased() {
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        assertNull(((JavascriptExecutor) driver).executeScript(
                "const delay = ms => new Promise(res => setTimeout(res, ms));\n"
                        + "await delay(arguments[0]);", 5000));
    }

    @Test(groups = "scriptTimeout")
    void testScriptTimeoutThrowsException() {
        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(50));
        assertThrows(ScriptTimeoutException.class, () -> ((JavascriptExecutor) driver).executeScript(
                "const delay = ms => new Promise(res => setTimeout(res, ms));\n"
                        + "await delay(arguments[0]);", 5000));
    }

    @Test(groups = "pageLoad")
    void testPageLoadTimeoutIncreased() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("http://uitestingplayground.com/loaddelay");
        assertFalse(
                driver.findElements(By.xpath("//button[text()='Button Appearing After Delay']")).isEmpty(),
                "Button not found");
    }

    @Test(groups = "pageLoad")
    void testPageLoadTimeoutThrowsException() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(50));
        assertThrows(TimeoutException.class,
                () -> driver.get("http://uitestingplayground.com/loaddelay"));
    }
}