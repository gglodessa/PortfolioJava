package uiTestingPlayground;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest extends BaseTest {

    @BeforeMethod()
    public void openSampleApp() {
        agent.openUrl(Url.UI_TESTING_PLAYGROUND_URL + "ajax");
    }

    @Test()
    public void testImplicitlyWaitIncreased() {
        agent.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        agent.onUiTestingPlaygroundPage().ajaxButton.click();
        Assert.assertFalse(agent.getDriver()
                        .findElements(By.xpath("//p[text()='Data loaded with AJAX get request.']"))
                        .isEmpty(), "AJAX Data was not loaded");
    }

    @Test()
    public void testImplicitlyWaitThrowsException() {
        agent.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        agent.onUiTestingPlaygroundPage().ajaxButton.click();
        Assert.assertThrows(NoSuchElementException.class,
                () -> agent.getDriver().findElement(By.xpath("//p[text()='Data loaded with AJAX get request.']")));
    }

    @Test()
    public void testScriptTimeoutIncreased() {
        agent.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        Assert.assertNull(((JavascriptExecutor) agent.getDriver()).executeScript(
                "const delay = ms => new Promise(res => setTimeout(res, ms));\n"
                        + "await delay(arguments[0]);", 5000));
    }

    @Test()
    public void testScriptTimeoutThrowsException() {
        agent.getDriver().manage().timeouts().scriptTimeout(Duration.ofMillis(50));
        Assert.assertThrows(ScriptTimeoutException.class, () -> ((JavascriptExecutor) agent.getDriver()).executeScript(
                "const delay = ms => new Promise(res => setTimeout(res, ms));\n"
                        + "await delay(arguments[0]);", 5000));
    }

    @Test()
    public void testPageLoadTimeoutIncreased() {
        agent.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        agent.getDriver().get("http://uitestingplayground.com/loaddelay");
        Assert.assertFalse(agent.getDriver()
                        .findElements(By.xpath("//button[text()='Button Appearing After Delay']"))
                        .isEmpty(), "Button not found");
    }

    @Test()
    public void testPageLoadTimeoutThrowsException() {
        agent.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(50));
        Assert.assertThrows(TimeoutException.class,
                () -> agent.getDriver().get("http://uitestingplayground.com/loaddelay"));
    }
}